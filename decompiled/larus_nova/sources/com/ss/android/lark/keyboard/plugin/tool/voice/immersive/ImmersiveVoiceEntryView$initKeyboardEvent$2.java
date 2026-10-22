package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "from", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", RemoteMessageConst.TO, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImmersiveVoiceEntryView$initKeyboardEvent$2 extends Lambda implements Function3<com.ss.android.lark.keyboard.event.g, cya.h, cya.h, Unit> {
    final /* synthetic */ v this$0;

    public ImmersiveVoiceEntryView$initKeyboardEvent$2(v r100) {
        this.this$0 = r100;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.ss.android.lark.keyboard.event.g r110, cya.h r111, cya.h r112) {
        Intrinsics.checkNotNullParameter(r110, "$this$selectTransform");
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.TO);
        int r113 = r112.a();
        if (r113 != 4) goto L5;
    L38:
        this.this$0.getClass();
        throw null;
    L5:
        if (r113 != 2) goto L9;
        if (KeyboardVoiceFGUtils.c() == false) goto L38;
    L9:
        if (r113 == 8) goto L38;
        if (KeyboardVoiceFGUtils.c() == false) goto L44;
        if (r113 != 2) goto L34;
        cya.i r114 = (cya.i) r112.f465978a.a(cya.i.f465980h);
        if (r114 == null) goto L18;
        boolean r100 = true;
        if (r114.f465986f != true) goto L18;
    L19:
        if (r100 == false) goto L34;
        v r101 = this.this$0;
        r101.getClass();
        CharSequence r115 = r114.f465983c;
        if (r115 != null) goto L23;
        r115 = "";
    L23:
        SpannableStringBuilder r102 = new SpannableStringBuilder(r115);
        Iterator r116 = ArrayIteratorKt.iterator((ncc.e[]) r102.getSpans(0, r102.length(), ncc.e.class));
    L25:
        if (r116.hasNext() == false) goto L34;
        ncc.e r103 = (ncc.e) r116.next();
        r103.a(new u(r101, null));
        Bitmap r104 = r103.f518725b;
        if (r104 == null) goto L31;
        Paint r105 = new Paint();
        r105.setColorFilter(null);
        Bitmap r106 = Bitmap.createBitmap(r104.getWidth(), r104.getHeight(), Bitmap.Config.ARGB_8888);
        if (r106 == null) goto L32;
        new Canvas(r106).drawBitmap(r104, 0.0f, 0.0f, r105);
    L32:
        r103.f518725b = r106;
        goto L25
    L31:
        r106 = null;
    L18:
        r100 = false;
    L34:
        if (r111.a() != 2) goto L45;
        if (r113 == 2) goto L46;
        this.this$0.getClass();
        return;
    L46:
        return;
    L45:
        return;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(com.ss.android.lark.keyboard.event.g r100, cya.h r101, cya.h r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
