package com.bytedance.ee.bear.lark.todoblock;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.lark.dependency.k0;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TodoBlockFragment extends Fragment {
    public TodoBlockViewModel d;

    public TodoBlockFragment() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.d = (TodoBlockViewModel) q.a(this, TodoBlockViewModel.class);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (getArguments() == null) goto L14;
        int r5 = getArguments().getInt("request_code");
        if (r5 != 1) goto L8;
        ((k0) a.a(k0.class)).c(this, r5);
        return;
    L8:
        if (r5 != 2) goto L11;
        String r6 = getArguments().getString("request_data");
        ((k0) a.a(k0.class)).b(this, r6, r5);
        return;
    L11:
        if (r5 != 3) goto L13;
        String r7 = getArguments().getString("request_data");
        ((k0) a.a(k0.class)).a(this, r7, r5);
        return;
    L13:
        tt5.a.d("TodoBlockFragment", "onActivityResult unknown request code!!");
        return;
    L14:
        tt5.a.d("TodoBlockFragment", "onCreate call getArguments null!!");
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r4 != 0) goto L12;
    L9:
        e = move-exception;
        tt5.a.d("TodoBlockFragment", "removeSelf error:" + e.getMessage());
        return;
    L5:
        if (getActivity() == null) goto L7;
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L9
    L19:
        return;
    L7:
        tt5.a.d("TodoBlockFragment", "removeSelf error: activity null");     // Catch: Exception -> L9
        goto L19
    L12:
        if (r4 != (-1)) goto L17;
        TodoBlockViewModel r1 = this.d;
        if (r1 == null) goto L16;
        r1.onActivityResult(r3, r4, r5);
        return;
    L16:
        tt5.a.d("TodoBlockFragment", "onActivityResult mTodoViewModel null!!");
        return;
    L17:
        tt5.a.d("TodoBlockFragment", "onActivityResult unknown result code:" + r3);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return new View(getContext());
    }
}
