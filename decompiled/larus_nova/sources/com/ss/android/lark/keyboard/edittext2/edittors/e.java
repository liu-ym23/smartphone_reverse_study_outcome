package com.ss.android.lark.keyboard.edittext2.edittors;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.VideoImageSpan;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import hob.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class e extends BaseFunctionEditor<g> implements com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f429054e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f429055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f429056d;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429057a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<e> a() {
            return this.f429057a.f428961a;
        }

        public a() {
            this.f429057a = new com.ss.android.lark.keyboard.edittext2.base.d(e.class);
        }
    }

    static {
        f429054e = new a();
    }

    public void V() {
    }

    public e() {
        this.f429055c = -1;
        this.f429056d = 1;
    }

    public void U(SpannableStringBuilder r110, g r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "data");
        Editable r100 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText();
        boolean r101 = false;
        if ((r100.getSpans(0, r100.length(), VideoImageSpan.class).length + r110.getSpans(0, r110.length(), VideoImageSpan.class).length) >= this.f429056d) goto L5;
        r101 = true;
    L5:
        if (r101 == true) goto L9;
        V();
        return;
    L9:
        if (r111.f486337e != null) goto L12;
        FrameInfo r102 = r111.f486336d;
        VideoInfo r103 = r111.f486335c;
        String r104 = r103.getPath();
        String r105 = r103.getCompressPath();
        String r106 = r102.getPath();
        int r107 = r102.getWidth();
        int r108 = r102.getHeight();
        String r109 = r103.getMimeType();
        int r112 = (int) r103.getDuration();
        long r113 = r103.getSize();
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r114 = RichTextElementCreator.f448209a;
        Intrinsics.checkNotNullParameter(r104, "originPath");
        Intrinsics.checkNotNullParameter(r105, "compressPath");
        Intrinsics.checkNotNullParameter(r106, "coverPath");
        Intrinsics.checkNotNullParameter(r109, DBDefinition.MIME_TYPE);
        RichTextElement.MediaProperty r115 = new RichTextElement.MediaProperty();
        r115.setOriginPath(r104);
        r115.setCompressPath(r105);
        r115.setCoverPath(r106);
        r115.setWidth(r107);
        r115.setHeight(r108);
        r115.setMime(r109);
        r115.setDuration(r112);
        r115.setSize(r113);
        r115.setMediaUploadId(r103.getMediaUploadId());
        r115.setImageUploadId(r103.getImageUploadId());
        r115.setKey(r103.getKey());
        r115.setOriginImage(r103.getOriginImage());
        r115.setUrl(r103.getUrl());
        r111.f486337e = r115;
    L12:
        int r116 = r110.length();
        String r117 = UIHelper.getString(R.string.Lark_Legacy_MessagePoVideo);
        VideoImageSpan r118 = new VideoImageSpan(context(), com.larksuite.framework.utils.e.g(r111.f486334b), r111.f486333a, new MediaEditor$onInsert$span$1(this));
        r118.f448634m = UIUtils.dp2px(context(), 2.0f);
        r118.f448635n = UIUtils.dp2px(context(), 1.0f);
        r118.f448637p = this.f429055c;
        r110.append(r117);
        r110.setSpan(r118, r116, r117.length() + r116, 33);
        com.ss.android.lark.keyboard.edittext2.widget.c.f429262a.getClass();
        r110.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.b(), r116, r117.length() + r116, 33);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, g r101, int r102) {
        U(r100, r101);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(g r100, SpannableStringBuilder r101, int r102, int r103) {
        g r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        RichTextElement.MediaProperty r105 = r104.f486337e;
        if (r105 == null) goto L6;
        r101.setSpan(new p(RichTextElementCreator.h(r105), r101.subSequence(r102, r103).toString()), r102, r103, 33);
        return;
    }
}
