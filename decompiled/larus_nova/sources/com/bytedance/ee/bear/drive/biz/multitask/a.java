package com.bytedance.ee.bear.drive.biz.multitask;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.ss.android.lark.multitask.task.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f223088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f223089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f223090c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.multitask.a$a, reason: collision with other inner class name */
    public static final class C3187a {
    }

    public interface b {
    }

    static {
    }

    @Override // com.ss.android.lark.multitask.task.b
    public final FragmentActivity a() {
        return getActivity();
    }

    @Override // com.ss.android.lark.multitask.task.b
    public /* bridge */ /* synthetic */ FragmentActivity getActivity() {
        return getActivity();
    }

    @Override // com.ss.android.lark.multitask.task.b
    public AppCompatActivity getActivity() {
        return this.f223088a;
    }

    public a(AppCompatActivity r100, Intent r101, String r102, com.bytedance.ee.bear.drive.core.a r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r103, "delegate");
        this.f223088a = r100;
        this.f223089b = r102;
        this.f223090c = r103;
    }
}
