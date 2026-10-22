package com.larus.home.impl.sdk;

import android.content.Context;
import android.os.Bundle;
import com.larus.doc.api.IDocService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n1 implements com.larus.platform.api.i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f346205a = null;

    static {
        f346205a = new n1();
    }

    public n1() {
    }

    @Override // com.larus.platform.api.i2
    public final int R() {
        return IDocService.f330931a.R();
    }

    public final void f() {
        IDocService.f330931a.clearReference();
    }

    public final void h() {
        IDocService.f330931a.enterStreamEditIfNeeded();
    }

    public final String i() {
        return IDocService.f330931a.W3();
    }

    public final String j() {
        return IDocService.f330931a.e4();
    }

    public final BotModel k() {
        return IDocService.f330931a.P4();
    }

    public final wc9.e l() {
        return IDocService.f330931a.p1();
    }

    public final String m() {
        return IDocService.f330931a.getCurScene();
    }

    public final Integer n() {
        return IDocService.f330931a.P9();
    }

    public final String o() {
        return IDocService.f330931a.w0();
    }

    public final int p() {
        return IDocService.f330931a.A();
    }

    public final String q() {
        return IDocService.f330931a.b7();
    }

    public final String r() {
        return IDocService.f330931a.r1();
    }

    public final String s() {
        return IDocService.f330931a.Y0();
    }

    public final String t() {
        return IDocService.f330931a.U0();
    }

    public final kotlinx.coroutines.flow.i1<Boolean> u() {
        return IDocService.f330931a.getVoiceInputStatus();
    }

    public final void v() {
        IDocService.f330931a.O9();
    }

    public final boolean w() {
        return IDocService.f330931a.Q9();
    }

    public final boolean z() {
        return IDocService.f330931a.shouldShowBackSegment();
    }

    @Override // com.larus.platform.api.i2
    public final String a(Message r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return com.larus.im.bean.message.a.c(r100);
    }

    @Override // com.larus.platform.api.i2
    public final String b(Message r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L24;
        if (r100 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L24;
        if (r100 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == true) goto L24;
        return null;
    L18:
        if (com.larus.im.bean.message.a.a0(r100) != true) goto L20;
        r103 = true;
        goto L21
    L12:
        if (com.larus.im.bean.message.a.t0(r100) != true) goto L14;
        r102 = true;
    L24:
        Iterator<T> r104 = com.larus.im.bean.message.a.d(r100).iterator();
    L26:
        if (r104.hasNext() == false) goto L33;
        Object r105 = r104.next();
        if (((Block) r105).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L26;
    L34:
        Block r107 = (Block) r105;
        if (r107 == null) goto L39;
        BlockContent r108 = r107.getContent();
        if (r108 == null) goto L39;
        ArtifactBlock r109 = r108.getDocBlock();
    L40:
        if (r109 != null) goto L42;
        return null;
    L42:
        return r109.getResourceId();
    L39:
        r109 = null;
        goto L40
    L30:
        r106 = false;
        goto L31
    L33:
        r105 = null;
        goto L34
    L5:
        if (com.larus.im.bean.message.a.l0(r100) != true) goto L7;
        r101 = true;
        goto L9
    }

    @Override // com.larus.platform.api.i2
    public final String c(Message r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L30;
        Iterator<T> r102 = com.larus.im.bean.message.a.d(r100).iterator();
    L10:
        ArtifactBlock r103 = null;
        if (r102.hasNext() == false) goto L18;
        Object r104 = r102.next();
        if (((Block) r104).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L10;
    L19:
        Block r106 = (Block) r104;
        if (r106 == null) goto L24;
        BlockContent r107 = r106.getContent();
        if (r107 == null) goto L24;
        r103 = r107.getDocBlock();
    L24:
        if (r103 == null) goto L27;
        String r108 = r103.getResourceId();
        if (r108 == null) goto L27;
        return r108;
    L27:
        return "";
    L15:
        r105 = false;
        goto L16
    L18:
        r104 = null;
        goto L19
    L30:
        return IDocService.f330931a.S9();
    L5:
        if (com.larus.im.bean.message.a.g0(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.platform.api.i2
    public final String d(Message r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L30;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L30;
        if (r100 != null) goto L17;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == true) goto L30;
        if (r100 != null) goto L23;
    L25:
        boolean r104 = false;
    L26:
        if (r104 == true) goto L30;
        return IDocService.f330931a.F9();
    L23:
        if (com.larus.im.bean.message.a.a0(r100) != true) goto L25;
        r104 = true;
        goto L26
    L17:
        if (com.larus.im.bean.message.a.t0(r100) != true) goto L19;
        r103 = true;
        goto L20
    L11:
        if (com.larus.im.bean.message.a.l0(r100) != true) goto L13;
        r102 = true;
    L30:
        Iterator<T> r105 = com.larus.im.bean.message.a.d(r100).iterator();
    L31:
        ArtifactBlock r106 = null;
        if (r105.hasNext() == false) goto L39;
        Object r107 = r105.next();
        if (((Block) r107).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L36;
        boolean r108 = true;
    L37:
        if (r108 == false) goto L31;
    L40:
        Block r109 = (Block) r107;
        if (r109 == null) goto L45;
        BlockContent r110 = r109.getContent();
        if (r110 == null) goto L45;
        r106 = r110.getDocBlock();
    L45:
        if (r106 == null) goto L48;
        String r111 = r106.getArtifactMetaId();
        if (r111 == null) goto L48;
        return r111;
    L48:
        return "";
    L36:
        r108 = false;
        goto L37
    L39:
        r107 = null;
        goto L40
    L5:
        if (com.larus.im.bean.message.a.g0(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.platform.api.i2
    public final Integer e(Message r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L30;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L30;
        if (r100 != null) goto L17;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == true) goto L30;
        if (r100 != null) goto L23;
    L25:
        boolean r104 = false;
    L26:
        if (r104 == true) goto L30;
        return IDocService.f330931a.w8();
    L23:
        if (com.larus.im.bean.message.a.a0(r100) != true) goto L25;
        r104 = true;
        goto L26
    L17:
        if (com.larus.im.bean.message.a.t0(r100) != true) goto L19;
        r103 = true;
        goto L20
    L11:
        if (com.larus.im.bean.message.a.l0(r100) != true) goto L13;
        r102 = true;
    L30:
        Iterator<T> r105 = com.larus.im.bean.message.a.d(r100).iterator();
    L32:
        if (r105.hasNext() == false) goto L39;
        Object r106 = r105.next();
        if (((Block) r106).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L36;
        boolean r107 = true;
    L37:
        if (r107 == false) goto L32;
    L40:
        Block r108 = (Block) r106;
        if (r108 == null) goto L45;
        BlockContent r109 = r108.getContent();
        if (r109 == null) goto L45;
        ArtifactBlock r110 = r109.getDocBlock();
    L46:
        if (r110 != null) goto L48;
        return null;
    L48:
        return r110.getResourceType();
    L45:
        r110 = null;
        goto L46
    L36:
        r107 = false;
        goto L37
    L39:
        r106 = null;
        goto L40
    L5:
        if (com.larus.im.bean.message.a.g0(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void B(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        IDocService.f330931a.N9(r100, r101, r102);
    }

    public final boolean g(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        return IDocService.f330931a.U9(r100, r101, r102);
    }

    public final void x(Context r100, Bundle r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        Intrinsics.checkNotNullParameter(r102, "page");
        IDocService.f330931a.Z9(r100, r101, r102);
    }

    public final boolean A(String r100, Integer r101, String r102, String r110, String r111) {
        return IDocService.f330931a.ca(r100, r101, r102, r110, r111);
    }

    public final boolean y(Context r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return IDocService.f330931a.G9(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.platform.api.i2
    public final void Q1(Message r110, String r111, boolean r112, String r113, Context r114, String r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "from");
        Intrinsics.checkNotNullParameter(r116, "currentPage");
        IDocService.f330931a.Q1(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
