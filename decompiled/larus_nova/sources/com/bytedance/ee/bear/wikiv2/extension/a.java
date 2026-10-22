package com.bytedance.ee.bear.wikiv2.extension;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements com.ss.android.lark.multitask.task.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f240692c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f240693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f240694b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.extension.a$a, reason: collision with other inner class name */
    public static final class C3449a {
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
        b r100 = this.f240694b;
        if (r100 == null) goto L7;
        String r101 = r100.getUrl();
        if (r101 == null) goto L7;
        return p.a().Z(r101);
    L7:
        return null;
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
        return this.f240693a;
    }

    public a(AppCompatActivity r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        this.f240693a = r100;
    }
}
