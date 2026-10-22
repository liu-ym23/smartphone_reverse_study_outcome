package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection$handleActivityResult$1;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class w1 extends c0c.b implements m6b.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.m f416588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.m> f416590d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.m
    public final Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r100) {
        return this.f416588b.Db(r100);
    }

    @Override // m6b.m
    public final Observable M4(List r100, boolean r101, CommentKeyboardSection$handleActivityResult$1 r102, Biz r110, Scene r111) {
        return this.f416588b.M4(r100, r101, r102, r110, r111);
    }

    @Override // m6b.m
    public final void d2(String r100, boolean r101, IGetDataCallback<List<MessageInfo>> r102) {
        this.f416588b.d2(r100, r101, r102);
    }

    public w1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.m> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.m.class), m6b.m.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416588b = r103.b();
        this.f416589c = r101;
        this.f416590d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("PostServiceProxy", "preparing IPostService");
        com.ss.android.lark.passportc.internal.v r102 = this.f416589c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        m6b.m r104 = (m6b.m) e0c.k.b(r102.c(r103), m6b.m.class);
        this.f416590d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
