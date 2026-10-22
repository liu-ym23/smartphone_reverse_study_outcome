package com.bytedance.annie.pro.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/annie/pro/ui/AnnieProFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieProFragment extends Fragment {
    public String d;

    public static final class a {
    }

    static {
    }

    public AnnieProFragment() {
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        String r7 = r6.getString("relative_path");
    L6:
        this.d = r7;
        AnnieProActivity r8 = getActivity();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.annie.pro.ui.AnnieProActivity");
        Uri r9 = UriProtector.parse(r8.a);
        String r0 = this.d;
        if (r0 == null) goto L9;
        r9 = kr3.a.b(r9, "start_page", r0);
    L9:
        View r10 = r3.inflate(2131563270, null);
        if (r10 == null) goto L12;
        BulletCardView r1 = (BulletCardView) r10.findViewById(2131362978);
    L13:
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r9, "uri");
        r1.h(r9, null, null, null);
    L15:
        return r10;
    L12:
        r1 = null;
        goto L13
    L5:
        r7 = null;
        goto L6
    }
}
