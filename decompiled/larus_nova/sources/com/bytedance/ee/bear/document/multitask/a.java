package com.bytedance.ee.bear.document.multitask;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.ss.android.lark.multitask.task.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f220390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f220391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f220392c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.multitask.a$a, reason: collision with other inner class name */
    public static final class C3141a {
    }

    public interface b {
        DocumentPluginHost getPluginHost();
    }

    public interface c {
        DocViewModel H0();
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
        return this.f220390a;
    }

    public a(AppCompatActivity r100, Intent r101, c r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "delegate");
        Intrinsics.checkNotNullParameter(r103, "host");
        this.f220390a = r100;
        this.f220391b = r102;
        this.f220392c = r103;
    }
}
