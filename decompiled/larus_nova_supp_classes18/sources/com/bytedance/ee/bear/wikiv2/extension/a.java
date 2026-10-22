package com.bytedance.ee.bear.wikiv2.extension;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.ss.android.lark.multitask.task.b {
    public static final /* synthetic */ int c = 0;
    public final AppCompatActivity a;
    public b b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.extension.a$a, reason: collision with other inner class name */
    public static final class C0202a {
    }

    public interface b {
        Boolean a();

        String getDocName();

        Integer getObjType();

        String getToken();

        String getUrl();
    }

    static {
    }

    public final BearUrl b() {
        b r0 = this.b;
        if (r0 == null) goto L7;
        String r1 = r0.getUrl();
        if (r1 == null) goto L7;
        return p.a().Z(r1);
    L7:
        return null;
    }

    public final FragmentActivity a() {
        return getActivity();
    }

    /* JADX INFO: renamed from: getActivity, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ FragmentActivity m667getActivity() {
        return getActivity();
    }

    public AppCompatActivity getActivity() {
        return this.a;
    }

    public a(AppCompatActivity r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "intent");
        this.a = r2;
    }
}
