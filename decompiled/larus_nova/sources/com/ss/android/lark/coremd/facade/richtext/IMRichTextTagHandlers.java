package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class IMRichTextTagHandlers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f419798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f419799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f419800c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f419801d = null;

    public static final class AtTagHandler extends RichTextTagHandlers.a {
        public AtTagHandler() {
        }

        @Override // com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers.a, b3c.a
        public final s b(final b3c.b r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            final s r101 = super.b(r100);
            final RichTextElement.AtProperty r102 = (RichTextElement.AtProperty) r100.getElement().getProperty();
            IMAtNodeExtend.f419650i.b(new IMRichTextTagHandlers$AtTagHandler$mapToNode$1(r101, r102, r100));
            return r101;
        }
    }

    public static final class ImageHandler extends RichTextTagHandlers.ImageTagHandler {
        public ImageHandler() {
        }

        @Override // com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers.ImageTagHandler, b3c.a
        public final s b(b3c.b r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            final s r101 = super.b(r100);
            final RichTextElement.ImageProperty r102 = (RichTextElement.ImageProperty) r100.getElement().getProperty();
            IMImageExtend.f419659p.b(new IMRichTextTagHandlers$ImageHandler$mapToNode$1(r101, r102));
            return r101;
        }
    }

    public static final class MediaHandler extends RichTextTagHandlers.q {
        public MediaHandler() {
        }

        @Override // com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers.q, b3c.a
        public final s b(b3c.b r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            final s r101 = super.b(r100);
            final RichTextElement.MediaProperty r102 = (RichTextElement.MediaProperty) r100.getElement().getProperty();
            final Image r103 = r102.getOriginImage();
            if (r103 != null) goto L9;
            Intrinsics.checkNotNull(r102);
            r103 = new Image();
            r103.setWidth(r102.getWidth());
            r103.setHeight(r102.getHeight());
            r103.setKey(r102.getKey());
            r103.setUrls(CollectionsKt.listOf(r102.getCoverPath()));
            if (r102.getResourceCleanScene() == null) goto L7;
            boolean r104 = true;
        L8:
            r103.setResourceIsCleaned(r104);
            r103.setResourceCleanScene(r102.getResourceCleanScene());
            goto L9
        L7:
            r104 = false;
        L9:
            IMMediaExtend.f419669q.b(new IMRichTextTagHandlers$MediaHandler$mapToNode$1(r101, r103, r102));
            return r101;
        }
    }

    static {
        f419798a = LazyKt.lazy(IMRichTextTagHandlers$atTagHandler$2.INSTANCE);
        f419799b = LazyKt.lazy(IMRichTextTagHandlers$imageHandler$2.INSTANCE);
        f419800c = LazyKt.lazy(IMRichTextTagHandlers$mediaHandler$2.INSTANCE);
        f419801d = LazyKt.lazy(IMRichTextTagHandlers$textBizExtend$2.INSTANCE);
    }
}
