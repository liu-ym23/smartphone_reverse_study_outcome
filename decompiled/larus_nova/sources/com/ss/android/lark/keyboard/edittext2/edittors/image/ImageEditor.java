package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.d;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.m0;
import hob.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class ImageEditor extends BaseFunctionEditor<f> implements com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f429058c = null;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<ImageEditor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f429059a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<ImageEditor> a() {
            return this.f429059a.f428961a;
        }

        public a() {
            this.f429059a = new d(ImageEditor.class);
        }
    }

    static {
        f429058c = new a();
    }

    public ImageEditor() {
    }

    public Object V(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "insertImageInfo");
        m0 r102 = new m0(r100, r101.f486327a, new ImageEditor$prepareSpan$span$1(this));
        r102.f448634m = UIUtils.dp2px(context(), 2.0f);
        r102.f448635n = UIUtils.dp2px(context(), 1.0f);
        r102.f448637p = r101.f486331e;
        return r102;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r100, f r101, int r110) {
        f r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "data");
        RichTextElement.ImageProperty r111 = r102.f486330d;
        if (r111 == null) goto L5;
        Boolean r112 = Boolean.valueOf(r111.isNeedCopy());
    L6:
        com.ss.android.lark.widget.span.b.AbstractC5432b<?> r103 = r102.f486327a;
        RichTextElement.ImageProperty r104 = RichTextElementCreator.c(r103.f448639a, r102.f486328b, r103.f448640b, r103.f448641c, r102.f486329c, null);
        r104.setNeedCopy(Intrinsics.areEqual(r112, Boolean.TRUE));
        r104.setOriginKey(r102.f486328b);
        r102.f486330d = r104;
        int r113 = r100.length();
        String r105 = UIHelper.getString(R.string.Lark_Legacy_ImageSummarize);
        r100.append(r105);
        r100.setSpan(V(context(), r102), r113, r105.length() + r113, 33);
        com.ss.android.lark.keyboard.edittext2.widget.c.f429262a.getClass();
        r100.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.b(), r113, r105.length() + r113, 33);
        return;
    L5:
        r112 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void T(f r100, SpannableStringBuilder r101, int r102, int r103) {
        U(r100, r101, r102, r103);
    }

    public void U(f r100, SpannableStringBuilder r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        RichTextElement.ImageProperty r104 = r100.f486330d;
        if (r104 == null) goto L6;
        r101.setSpan(new p(RichTextElementCreator.h(r104), r101.subSequence(r102, r103).toString()), r102, r103, 33);
        return;
    }
}
