package com.ss.android.lark.keyboard.edittext2.edittors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class d extends BaseFunctionEditor<String> implements com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f429050e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f429051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f429052d;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429053a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<d> a() {
            return this.f429053a.f428961a;
        }

        public a() {
            this.f429053a = new com.ss.android.lark.keyboard.edittext2.base.d(d.class);
        }
    }

    static {
        f429050e = new a();
    }

    public d() {
        this.f429052d = 1;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
        this.f429051c = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, String r101, int r102) {
        U(r100, r101, r102);
    }

    public void U(SpannableStringBuilder r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "emojiKey");
        Context r100 = context();
        Drawable r101 = EmojiHandler.c(r111, null, null);
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = EmojiHandler.e(r111);
        float r103 = this.f429051c;
        if (r103 > 0.0f) goto L8;
        r103 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize();
    L8:
        Object r104 = new com.ss.android.lark.widget.linked_emojicon.base.a(r100, r101, r111, (int) r103, this.f429052d, (int) com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize());
        r110.append(r102);
        r110.setSpan(r104, r112, r102.length() + r112, 33);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(String r100, SpannableStringBuilder r101, int r102, int r103) {
        String r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r105 = RichTextElementCreator.f448209a;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        Intrinsics.checkNotNullParameter(r104, "emojiKey");
        RichTextElement.EmotionProperty r106 = new RichTextElement.EmotionProperty();
        r106.setKey(r104);
        r101.setSpan(new p(RichTextElementCreator.h(r106), r101.subSequence(r102, r103).toString()), r102, r103, 33);
    }
}
