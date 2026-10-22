package com.larus.bmhome.chat.detail.code;

import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f302743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f302744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n0 f302745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larus.im.internal.research.d.a f302746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f302747e;

    public static final class a {
    }

    static {
    }

    public static String a(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((Block) r102).getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.f302411e) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        Block r104 = (Block) r102;
        if (r104 == null) goto L21;
        BlockContent r105 = r104.getContent();
        if (r105 == null) goto L21;
        TextBlock r106 = r105.getTextBlock();
        if (r106 == null) goto L21;
        String r107 = r106.text;
        if (r107 == null) goto L21;
        return r107;
    L21:
        return "";
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    public h0(String r100, CodeBlockDetailFragment.c r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        this.f302743a = r100;
        this.f302745c = r101;
        this.f302747e = LazyKt.lazy(new g0());
    }
}
