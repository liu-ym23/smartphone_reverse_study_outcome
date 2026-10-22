package com.larus.bmhome.music.player;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements ad9.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f312949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MusicCreationContent f312950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MusicCreationContent f312951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<ad9.b.C0057b> f312952e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MusicCreationContent f312953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableSharedFlow<ad9.b.C0057b> f312954b;

        public a() {
            this.f312954b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        }
    }

    @Override // ad9.b
    public final String a() {
        return "Creation";
    }

    @Override // ad9.b
    public final boolean c() {
        return false;
    }

    @Override // ad9.b
    public final boolean getHasNext() {
        return true;
    }

    @Override // ad9.b
    public final boolean getHasPrevious() {
        return true;
    }

    @Override // ad9.b
    public final String getItemId() {
        return "0";
    }

    @Override // ad9.b
    public final MutableSharedFlow<ad9.b.C0057b> b() {
        return this.f312952e;
    }

    @Override // ad9.b
    public final MusicCreationContent d() {
        return this.f312951d;
    }

    @Override // ad9.b
    public final MusicCreationContent getNext() {
        return this.f312950c;
    }

    @Override // ad9.b
    public final String getVid() {
        return this.f312949b;
    }

    public d(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bindDecorator");
        Intrinsics.checkNotNullParameter(r101, "vidPlay");
        this.f312949b = r101;
        this.f312952e = r100.f312954b;
    }
}
