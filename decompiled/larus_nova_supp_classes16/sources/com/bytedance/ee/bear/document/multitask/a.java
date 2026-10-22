package com.bytedance.ee.bear.document.multitask;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.ss.android.lark.multitask.task.b {
    public final AppCompatActivity a;
    public final c b;
    public final b c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.multitask.a$a, reason: collision with other inner class name */
    public static final class C0085a {
    }

    public interface b {
        DocumentPluginHost getPluginHost();
    }

    public interface c {
        DocViewModel H0();
    }

    static {
    }

    public final FragmentActivity a() {
        return getActivity();
    }

    /* JADX INFO: renamed from: getActivity, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ FragmentActivity m224getActivity() {
        return getActivity();
    }

    public AppCompatActivity getActivity() {
        return this.a;
    }

    public a(AppCompatActivity r2, Intent r3, c r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "intent");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        Intrinsics.checkNotNullParameter(r5, "host");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
