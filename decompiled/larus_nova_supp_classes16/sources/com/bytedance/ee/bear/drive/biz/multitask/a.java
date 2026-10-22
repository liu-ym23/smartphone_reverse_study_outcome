package com.bytedance.ee.bear.drive.biz.multitask;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.ss.android.lark.multitask.task.b {
    public final AppCompatActivity a;
    public final String b;
    public final b c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.multitask.a$a, reason: collision with other inner class name */
    public static final class C0131a {
    }

    public interface b {
    }

    static {
    }

    public final FragmentActivity a() {
        return getActivity();
    }

    /* JADX INFO: renamed from: getActivity, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ FragmentActivity m301getActivity() {
        return getActivity();
    }

    public AppCompatActivity getActivity() {
        return this.a;
    }

    public a(AppCompatActivity r2, Intent r3, String r4, com.bytedance.ee.bear.drive.core.a r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "intent");
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
