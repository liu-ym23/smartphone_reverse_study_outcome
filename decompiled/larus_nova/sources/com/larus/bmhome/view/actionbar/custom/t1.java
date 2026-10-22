package com.larus.bmhome.view.actionbar.custom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.actionbar.model.ReplyOption;

/* JADX INFO: loaded from: classes26.dex */
public interface t1 {

    public static final class a {
        public static /* synthetic */ void a(t1 r100, com.larus.bmhome.actionbar.model.z0 r101, int r102, Boolean r110, View r111, boolean r112) {
            r100.b(r101, r102, r110, r111, r112, null);
        }
    }

    String a();

    void b(com.larus.bmhome.actionbar.model.z0 r100, int r101, Boolean r102, View r103, boolean r104, aq8.e r105);

    kotlinx.coroutines.flow.i1<Boolean> c(String r100);

    void d(View r100, ImageView r101, TextView r102, com.larus.bmhome.actionbar.model.z0 r103);

    LifecycleCoroutineScope e();

    int f();

    ReplyOption g(com.larus.bmhome.actionbar.model.z0 r100);
}
