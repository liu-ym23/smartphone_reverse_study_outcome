package com.bytedance.lark.lark_markdown_render_android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lark_markdown_render.proto.FuncParamsX128e7aed481f35b9;
import lark_markdown_render.proto.FuncParamsX263d27dbec1bcaad;
import lark_markdown_render.proto.FuncParamsX302a81fd1e3f62ae;
import lark_markdown_render.proto.FuncParamsX3bb861e377637789;
import lark_markdown_render.proto.FuncParamsX3f2cec9ef12393f7;
import lark_markdown_render.proto.FuncParamsX4314480f8beb223c;
import lark_markdown_render.proto.FuncParamsX47a9fcbf1062f608;
import lark_markdown_render.proto.FuncParamsX47e8a258d7042136;
import lark_markdown_render.proto.FuncParamsX6cfe857e49a7f925;
import lark_markdown_render.proto.FuncParamsX710fe409271b5ca7;
import lark_markdown_render.proto.FuncParamsX7ebda7b1245bc0ff;
import lark_markdown_render.proto.FuncParamsX95952a77259068fc;
import lark_markdown_render.proto.FuncParamsX9770f9919ae2737d;
import lark_markdown_render.proto.FuncParamsX9cdbe2b96ec2b9d9;
import lark_markdown_render.proto.FuncParamsXb93ca91530509a90;
import lark_markdown_render.proto.FuncParamsXbefd9658286129cf;
import lark_markdown_render.proto.FuncParamsXe97a81031974399b;
import lark_markdown_render.proto.FuncParamsXf48f33eae5ff1bb1;
import lark_markdown_render.proto.FuncReturnX042ac4d5a07e821f;
import lark_markdown_render.proto.FuncReturnX0bf8b5c665c57f35;
import lark_markdown_render.proto.FuncReturnX3dc8b8542df1cbb1;
import lark_markdown_render.proto.FuncReturnX899e98b47a458199;
import lark_markdown_render.proto.FuncReturnXb05c0e03c1bfe022;
import lark_markdown_render.proto.FuncReturnXcbb624c70e011a12;
import lark_markdown_render.proto.MoltenContextExtra;
import lark_markdown_render.proto.MoltenFfiInstanceMsg;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a8\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a8\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u001a(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a(\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b \u0010\u001e\u001a(\u0010!\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001e\u001a8\u0010#\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0018\u001a(\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a \u0010*\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a \u0010-\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b.\u0010,\u001a(\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a.\u00104\u001a\b\u0012\u0004\u0012\u0002050\n2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a(\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b9\u00103\u001a(\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u000e\u0010A\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=\u001a\u000e\u0010B\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u000b\u001a,\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010J\u001a\u0018\u0010K\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a(\u0010N\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bO\u00103\u001a(\u0010P\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bQ\u00103\u001a(\u0010R\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bS\u00103\u001a \u0010T\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bU\u0010\b\u001a \u0010V\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bW\u0010\b\u001a(\u0010X\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bZ\u00103\u001a\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020&H\u0002\u001a\u0010\u0010]\u001a\u00020\u00102\b\u0010^\u001a\u0004\u0018\u00010_\u001a8\u0010`\u001a\u00020=2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\f\u0010d\u001a\u00020e*\u00020\u0012H\u0000\u001a\n\u0010d\u001a\u00020f*\u00020g\u001a\n\u0010d\u001a\u00020h*\u00020i\u001a\n\u0010d\u001a\u00020j*\u00020k\u001a\n\u0010d\u001a\u00020l*\u00020m\u001a\n\u0010d\u001a\u000205*\u00020n\u001a\n\u0010d\u001a\u00020o*\u00020p\u001a\n\u0010d\u001a\u00020q*\u00020r\u001a\n\u0010d\u001a\u00020s*\u00020t\u001a\n\u0010d\u001a\u00020u*\u00020v\u001a\n\u0010d\u001a\u00020w*\u00020x\u001a\n\u0010d\u001a\u00020y*\u00020z\u001a\n\u0010d\u001a\u00020{*\u00020|\u001a\n\u0010d\u001a\u00020D*\u00020}\u001a\n\u0010d\u001a\u00020~*\u00020\u007f\u001a\u000b\u0010d\u001a\u00020H*\u00030\u0080\u0001\u001a\f\u0010d\u001a\u00030\u0081\u0001*\u00030\u0082\u0001\u001a\u000b\u0010d\u001a\u00020J*\u00030\u0083\u0001\u001a\f\u0010d\u001a\u00030\u0084\u0001*\u00030\u0085\u0001\u001a\f\u0010d\u001a\u00030\u0086\u0001*\u00030\u0087\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0088\u0001"}, d2 = {"CALLBACK_IDX_FREE", "", "ffiGetHighlightStream", "", "documentId", "Lkotlin/UInt;", "documentVersion", "ffiGetHighlightStream-feOb9K0", "(II)[B", "ffiGetTailElement", "", "", "renderId", "ffiGetTailElement-feOb9K0", "(II)Ljava/util/List;", "ffiInitRenderPoolService", "", "service", "Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "ffiMovableCallDoubleTap", "canvasId", "x", "y", "ffiMovableCallDoubleTap-6Thg8X8", "(IIIFF)V", "ffiMovableCallLongPress", "ffiMovableCallLongPress-6Thg8X8", "ffiMovableCallPickCaret", "uuid", "ffiMovableCallPickCaret-zly0blg", "(III)V", "ffiMovableCallSelectAll", "ffiMovableCallSelectAll-zly0blg", "ffiMovableCallTouchCancelled", "ffiMovableCallTouchCancelled-zly0blg", "ffiMovableCallTouchMove", "ffiMovableCallTouchMove-6Thg8X8", "ffiMovableGetIslandMarkdown", "", "islandId", "ffiMovableGetIslandMarkdown-zly0blg", "(III)Ljava/lang/String;", "ffiMovableGetMarkdownFromRange", "ffiMovableGetMarkdownFromRange-feOb9K0", "(II)Ljava/lang/String;", "ffiMovableGetTextFromRange", "ffiMovableGetTextFromRange-feOb9K0", "ffiMovableRequestAttachmentsDiff", "fromVersion", "toVersion", "ffiMovableRequestAttachmentsDiff-zly0blg", "(III)[B", "ffiMovableRequestCarets", "Lcom/bytedance/lark/lark_markdown_render_android/FfiCaret;", "ffiMovableRequestCarets-zly0blg", "(III)Ljava/util/List;", "ffiMovableRequestIslandsDiff", "ffiMovableRequestIslandsDiff-zly0blg", "ffiMovableRsInitDeviceInfo", "deviceType", "isDarkMode", "", "zoomLevel", "ffiMovableRsInitDeviceInfo-OzbTU-A", "(IZF)V", "ffiMovableRsUpdateDarkMode", "ffiMovableRsUpdateFontZoom", "ffiParseMarkdownForClient", "Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "markdown", "preferWidth", "renderConfig", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", "urlPreviewInlines", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;", "ffiReleaseMovableDocumentForClient", "ffiReleaseMovableDocumentForClient-WZ4Q5Ns", "(I)V", "ffiRequestIslandHighlightStream", "ffiRequestIslandHighlightStream-zly0blg", "ffiRequestIslandRenderStream", "ffiRequestIslandRenderStream-zly0blg", "ffiRequestIslandRenderStreamInTextApi", "ffiRequestIslandRenderStreamInTextApi-zly0blg", "ffiRequestRenderStream", "ffiRequestRenderStream-feOb9K0", "ffiRequestRenderStreamInTextApi", "ffiRequestRenderStreamInTextApi-feOb9K0", "ffiRequestRenderStreamWithWidth", "renderWidth", "ffiRequestRenderStreamWithWidth-zly0blg", "findLibraryName", "componentName", "setContextHoook", "contextHook", "Lcom/bytedance/lark/lark_markdown_render_android/ContextHook;", "triggerClick", "instanceId", "triggerClick-6Thg8X8", "(IIIFF)Z", "into", "Llark_markdown_render/proto/MoltenFfiInstanceMsg;", "Lcom/bytedance/lark/lark_markdown_render_android/AttachmentTypeId;", "Llark_markdown_render/proto/AttachmentTypeId;", "Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "Llark_markdown_render/proto/CodeBlockConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;", "Llark_markdown_render/proto/DocumentConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "Llark_markdown_render/proto/EdgeInsets;", "Llark_markdown_render/proto/FfiCaret;", "Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "Llark_markdown_render/proto/FontStyle;", "Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "Llark_markdown_render/proto/FontWeight;", "Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;", "Llark_markdown_render/proto/HeadingConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "Llark_markdown_render/proto/HeadingLevelConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;", "Llark_markdown_render/proto/InlineCodeConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/LinkConfig;", "Llark_markdown_render/proto/LinkConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "Llark_markdown_render/proto/ListConfig;", "Llark_markdown_render/proto/MovableDocumentInfo;", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderAtProperty;", "Llark_markdown_render/proto/MovableRenderAtProperty;", "Llark_markdown_render/proto/MovableRenderConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInline;", "Llark_markdown_render/proto/MovableRenderUrlPreviewInline;", "Llark_markdown_render/proto/MovableRenderUrlPreviewInlines;", "Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;", "Llark_markdown_render/proto/TableConfig;", "Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "Llark_markdown_render/proto/ThematicBreakConfig;", "lark_markdown_render_android_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Lark_markdown_renderKt {
    public static final long CALLBACK_IDX_FREE = 0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[lark_markdown_render.proto.AttachmentTypeId.values().length];
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L36:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L50:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_DATA_SLOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L38:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L40:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L30:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L42:
            r0[lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L11:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[lark_markdown_render.proto.FontStyle.values().length];
            r1[lark_markdown_render.proto.FontStyle.VAR_FONT_STYLE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L32:
            r1[lark_markdown_render.proto.FontStyle.VAR_FONT_STYLE_ITALIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L14:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[lark_markdown_render.proto.FontWeight.values().length];
            r2[lark_markdown_render.proto.FontWeight.VAR_FONT_WEIGHT_REGULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L34:
            r2[lark_markdown_render.proto.FontWeight.VAR_FONT_WEIGHT_BOLD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L17:
            $EnumSwitchMapping$2 = r2;
        }
    }

    public static final /* synthetic */ String access$findLibraryName(String r0) {
        return findLibraryName(r0);
    }

    public static final void ffiInitRenderPoolService(MovableCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "service");
        MoltenFfiLibLarkMarkdownRender.Companion r1 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r0 = r1.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiInitRenderPoolService"));
        byte[] r8 = new FuncParamsX47e8a258d7042136(into(r9), r0).encode();
        long r2 = r1.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L6
        byte[] r10 = r1.molten_ffi_lark_markdown_render_call(r2, 0, -5100206181525524603L, r8);     // Catch: RuntimeException -> L6
        MoltenContextExtra r11 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r10);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r3 = DefaultCallStatusErrorHandler.INSTANCE;
        String r12 = e.getMessage();
        Intrinsics.checkNotNull(r12);
        throw r3.report$lark_markdown_render_android_release(new UnhandledException(r12));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    public static final void ffiMovableRsUpdateDarkMode(boolean r9) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRsUpdateDarkMode"));
        byte[] r7 = new FuncParamsX9770f9919ae2737d(Boolean.valueOf(r9), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r10 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 6949223573070890474L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r11 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r10);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r3 = DefaultCallStatusErrorHandler.INSTANCE;
        String r12 = e.getMessage();
        Intrinsics.checkNotNull(r12);
        throw r3.report$lark_markdown_render_android_release(new UnhandledException(r12));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    public static final void ffiMovableRsUpdateFontZoom(float r9) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRsUpdateFontZoom"));
        byte[] r7 = new FuncParamsX95952a77259068fc(Float.valueOf(r9), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r10 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -7523117207440631655L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r11 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r10);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r3 = DefaultCallStatusErrorHandler.INSTANCE;
        String r12 = e.getMessage();
        Intrinsics.checkNotNull(r12);
        throw r3.report$lark_markdown_render_android_release(new UnhandledException(r12));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiReleaseMovableDocumentForClient-WZ4Q5Ns, reason: not valid java name */
    public static final void m477ffiReleaseMovableDocumentForClientWZ4Q5Ns(int r9) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiReleaseMovableDocumentForClient"));
        byte[] r7 = new FuncParamsXe97a81031974399b(Integer.valueOf(r9), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r10 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 2140711924973025582L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r11 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r10);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r3 = DefaultCallStatusErrorHandler.INSTANCE;
        String r12 = e.getMessage();
        Intrinsics.checkNotNull(r12);
        throw r3.report$lark_markdown_render_android_release(new UnhandledException(r12));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    private static final synchronized String findLibraryName(String r3) {
        monitor-enter(Lark_markdown_renderKt.class);
        String r4 = System.getProperty("molten_ffi." + r3 + ".lib_name");     // Catch: Throwable -> L9
        if (r4 != null) goto L7;
        r4 = "lark";
    L7:
        monitor-exit(Lark_markdown_renderKt.class);
        return r4;
    L9:
        th = move-exception;
        throw th;
    }

    public static final MovableRenderConfig into(lark_markdown_render.proto.MovableRenderConfig r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        lark_markdown_render.proto.DocumentConfig r0 = r12.document_config;
        LinkConfig r1 = null;
        if (r0 == null) goto L5;
        DocumentConfig r3 = into(r0);
    L6:
        lark_markdown_render.proto.HeadingConfig r2 = r12.heading_config;
        if (r2 == null) goto L9;
        HeadingConfig r4 = into(r2);
    L10:
        lark_markdown_render.proto.CodeBlockConfig r5 = r12.code_block_config;
        if (r5 == null) goto L13;
        CodeBlockConfig r6 = into(r5);
    L14:
        lark_markdown_render.proto.InlineCodeConfig r7 = r12.inline_code_config;
        if (r7 == null) goto L17;
        InlineCodeConfig r8 = into(r7);
    L18:
        lark_markdown_render.proto.ThematicBreakConfig r9 = r12.thematic_break_config;
        if (r9 == null) goto L21;
        ThematicBreakConfig r10 = into(r9);
    L22:
        lark_markdown_render.proto.ListConfig r11 = r12.list_config;
        if (r11 == null) goto L25;
        ListConfig r13 = into(r11);
    L26:
        lark_markdown_render.proto.TableConfig r14 = r12.table_config;
        if (r14 == null) goto L29;
        TableConfig r16 = into(r14);
    L30:
        lark_markdown_render.proto.LinkConfig r17 = r12.link_config;
        if (r17 == null) goto L33;
        r1 = into(r17);
    L33:
        LinkConfig r18 = r1;
        Map r19 = r12.at_users;
        LinkedHashMap r110 = new LinkedHashMap(MapsKt.mapCapacity(r19.size()));
        Iterator r111 = r19.entrySet().iterator();
    L35:
        if (r111.hasNext() == false) goto L38;
        Map.Entry r20 = (Map.Entry) r111.next();
        r110.put(r20.getKey(), into((lark_markdown_render.proto.MovableRenderAtProperty) r20.getValue()));
        goto L35
    L38:
        return new MovableRenderConfig(r3, r4, r6, r8, r10, r13, r16, r18, r110);
    L29:
        r16 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final void setContextHoook(ContextHook r1) {
        MoltenFfiLibLarkMarkdownRender.Companion.setContextHook$lark_markdown_render_android_release(r1);
    }

    public static final HeadingConfig into(lark_markdown_render.proto.HeadingConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        lark_markdown_render.proto.HeadingLevelConfig r0 = r9.h1;
        HeadingLevelConfig r1 = null;
        if (r0 == null) goto L5;
        HeadingLevelConfig r3 = into(r0);
    L6:
        lark_markdown_render.proto.HeadingLevelConfig r2 = r9.h2;
        if (r2 == null) goto L9;
        HeadingLevelConfig r4 = into(r2);
    L10:
        lark_markdown_render.proto.HeadingLevelConfig r5 = r9.h3;
        if (r5 == null) goto L13;
        HeadingLevelConfig r6 = into(r5);
    L14:
        lark_markdown_render.proto.HeadingLevelConfig r7 = r9.h4;
        if (r7 == null) goto L17;
        HeadingLevelConfig r8 = into(r7);
    L18:
        lark_markdown_render.proto.HeadingLevelConfig r10 = r9.h5;
        if (r10 == null) goto L21;
        HeadingLevelConfig r11 = into(r10);
    L22:
        lark_markdown_render.proto.HeadingLevelConfig r12 = r9.h6;
        if (r12 == null) goto L26;
        r1 = into(r12);
    L26:
        return new HeadingConfig(r3, r4, r6, r8, r11, r1);
    L21:
        r11 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final DocumentConfig into(lark_markdown_render.proto.DocumentConfig r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Float r2 = r14.font_size;
        lark_markdown_render.proto.FontWeight r0 = r14.font_weight;
        if (r0 == null) goto L5;
        FontWeight r3 = into(r0);
    L6:
        Float r4 = r14.heading_gap;
        Float r5 = r14.paragraph_gap;
        Float r6 = r14.media_block_margin_top;
        Float r7 = r14.media_block_margin_bottom;
        Float r8 = r14.item_gap;
        Float r9 = r14.line_height;
        String r10 = r14.background_color;
        String r11 = r14.foreground_color;
        lark_markdown_render.proto.EdgeInsets r1 = r14.doc_padding;
        if (r1 == null) goto L9;
        EdgeInsets r12 = into(r1);
    L10:
        lark_markdown_render.proto.EdgeInsets r16 = r14.paragraph_padding;
        if (r16 == null) goto L13;
        EdgeInsets r13 = into(r16);
    L15:
        return new DocumentConfig(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L13:
        r13 = null;
        goto L15
    L9:
        r12 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final AttachmentTypeId into(lark_markdown_render.proto.AttachmentTypeId r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return AttachmentTypeId.ImUrlPreviewIcon;
    L15:
        return AttachmentTypeId.CodeBlockCopyIcon;
    L16:
        return AttachmentTypeId.Image;
    L17:
        return AttachmentTypeId.DocCanvas;
    L18:
        return AttachmentTypeId.DataSlot;
    L19:
        return AttachmentTypeId.ImageGallery;
    L13:
        return AttachmentTypeId.LegacyCodeBlockCopyIcon;
    }

    public static final CodeBlockConfig into(lark_markdown_render.proto.CodeBlockConfig r16) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Float r2 = r16.font_size;
        lark_markdown_render.proto.FontStyle r0 = r16.font_style;
        if (r0 == null) goto L5;
        FontStyle r3 = into(r0);
    L6:
        Float r4 = r16.line_height;
        String r5 = r16.caption_color;
        String r6 = r16.background_color;
        Float r7 = r16.header_height;
        Float r8 = r16.copy_size;
        String r9 = r16.header_background_color;
        Float r10 = r16.border_radius;
        Float r11 = r16.border_width;
        String r12 = r16.border_color;
        Float r13 = r16.padding;
        lark_markdown_render.proto.EdgeInsets r17 = r16.header_padding;
        if (r17 == null) goto L9;
        EdgeInsets r14 = into(r17);
    L11:
        return new CodeBlockConfig(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L9:
        r14 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public static final FfiCaret into(lark_markdown_render.proto.FfiCaret r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new FfiCaret(r9.x.floatValue(), r9.y.floatValue(), r9.height.floatValue(), r9.direction.booleanValue(), UInt.constructor-impl(r9.uuid.intValue()), UInt.constructor-impl(r9.canvas_id.intValue()), null);
    }

    public static final InlineCodeConfig into(lark_markdown_render.proto.InlineCodeConfig r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Float r2 = r12.font_size;
        lark_markdown_render.proto.FontStyle r0 = r12.font_style;
        if (r0 == null) goto L5;
        FontStyle r1 = into(r0);
    L7:
        return new InlineCodeConfig(r2, r1, r12.line_height, r12.horizontal_margin.floatValue(), r12.horizontal_inner_margin.floatValue(), r12.background_color, r12.foreground_color, r12.border_color, r12.border_width.floatValue(), r12.border_radius.floatValue());
    L5:
        r1 = null;
        goto L7
    }

    public static final MovableRenderUrlPreviewInlines into(lark_markdown_render.proto.MovableRenderUrlPreviewInlines r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List r3 = r2.items;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        lark_markdown_render.proto.MovableRenderUrlPreviewInline r1 = (lark_markdown_render.proto.MovableRenderUrlPreviewInline) r4.next();
        Intrinsics.checkNotNull(r1);
        r0.add(into(r1));
        goto L4
    L7:
        return new MovableRenderUrlPreviewInlines(r0);
    }

    public static final MovableDocumentInfo into(lark_markdown_render.proto.MovableDocumentInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new MovableDocumentInfo(UInt.constructor-impl(r7.document_id.intValue()), UInt.constructor-impl(r7.document_version.intValue()), r7.width.floatValue(), r7.height.floatValue(), null);
    }

    public static final TableConfig into(lark_markdown_render.proto.TableConfig r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        String r2 = r13.header_background_color;
        String r3 = r13.cell_background_color;
        String r4 = r13.table_border_color;
        Float r5 = r13.table_font_size;
        Float r6 = r13.table_line_height;
        Float r7 = r13.cell_min_width;
        Float r8 = r13.cell_max_width;
        Float r9 = r13.table_border_width;
        Float r10 = r13.table_border_radius;
        Float r11 = r13.cell_padding;
        lark_markdown_render.proto.EdgeInsets r14 = r13.cell_padding_insets;
        if (r14 == null) goto L5;
        EdgeInsets r16 = into(r14);
    L7:
        return new TableConfig(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r16);
    L5:
        r16 = null;
        goto L7
    }

    public static final ListConfig into(lark_markdown_render.proto.ListConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r2 = r9.ordered_marker_color;
        Float r3 = r9.ordered_marker_font_size;
        String r4 = r9.unordered_marker_color;
        Float r5 = r9.unordered_marker_font_size;
        Float r6 = r9.block_gap;
        Float r7 = r9.item_gap;
        lark_markdown_render.proto.EdgeInsets r10 = r9.item_padding;
        if (r10 == null) goto L5;
        EdgeInsets r11 = into(r10);
    L7:
        return new ListConfig(r2, r3, r4, r5, r6, r7, r11);
    L5:
        r11 = null;
        goto L7
    }

    public static final HeadingLevelConfig into(lark_markdown_render.proto.HeadingLevelConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Float r0 = r4.font_size;
        lark_markdown_render.proto.FontWeight r1 = r4.font_weight;
        EdgeInsets r2 = null;
        if (r1 == null) goto L5;
        FontWeight r3 = into(r1);
    L6:
        Float r5 = r4.line_height;
        lark_markdown_render.proto.EdgeInsets r6 = r4.padding;
        if (r6 == null) goto L10;
        r2 = into(r6);
    L10:
        return new HeadingLevelConfig(r0, r3, r5, r2);
    L5:
        r3 = null;
        goto L6
    }

    public static final FontStyle into(lark_markdown_render.proto.FontStyle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return FontStyle.Italic;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FontStyle.Normal;
    }

    public static final FontWeight into(lark_markdown_render.proto.FontWeight r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = WhenMappings.$EnumSwitchMapping$2[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return FontWeight.Bold;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FontWeight.Regular;
    }

    public static final MoltenFfiInstanceMsg into(MovableCallback r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new MoltenFfiInstanceMsg(-1865477608297644138L, Long.valueOf(MovableCallbackProxy.Companion.obtain(r4)));
    }

    public static final MovableRenderUrlPreviewInline into(lark_markdown_render.proto.MovableRenderUrlPreviewInline r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return new MovableRenderUrlPreviewInline(r8.preview_id, r8.origin_url, r8.click_url, r8.title, r8.icon_key, r8.icon_type);
    }

    public static final ThematicBreakConfig into(lark_markdown_render.proto.ThematicBreakConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new ThematicBreakConfig(r4.height.floatValue(), r4.line_color, r4.margin_top, r4.margin_bottom);
    }

    public static final MovableRenderAtProperty into(lark_markdown_render.proto.MovableRenderAtProperty r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new MovableRenderAtProperty(r7.user_id, r7.content, r7.is_outer, r7.is_anonymous, r7.is_highlight);
    }

    public static final EdgeInsets into(lark_markdown_render.proto.EdgeInsets r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new EdgeInsets(r4.top, r4.right, r4.bottom, r4.left);
    }

    public static final LinkConfig into(lark_markdown_render.proto.LinkConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new LinkConfig(r1.link_color);
    }

    /* JADX INFO: renamed from: ffiGetHighlightStream-feOb9K0, reason: not valid java name */
    public static final byte[] m462ffiGetHighlightStreamfeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiGetHighlightStream"));
        byte[] r7 = new FuncParamsX7ebda7b1245bc0ff(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -7302930329156235164L, r7);     // Catch: RuntimeException -> L6
        ByteString r12 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiGetTailElement-feOb9K0, reason: not valid java name */
    public static final List<Float> m463ffiGetTailElementfeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiGetTailElement"));
        byte[] r7 = new FuncParamsX6cfe857e49a7f925(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 293822937355099235L, r7);     // Catch: RuntimeException -> L6
        List<Float> r12 = ((FuncReturnX042ac4d5a07e821f) FuncReturnX042ac4d5a07e821f.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableGetMarkdownFromRange-feOb9K0, reason: not valid java name */
    public static final String m471ffiMovableGetMarkdownFromRangefeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableGetMarkdownFromRange"));
        byte[] r7 = new FuncParamsX7ebda7b1245bc0ff(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -8319388843913684737L, r7);     // Catch: RuntimeException -> L6
        String r12 = ((FuncReturnX0bf8b5c665c57f35) FuncReturnX0bf8b5c665c57f35.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableGetTextFromRange-feOb9K0, reason: not valid java name */
    public static final String m472ffiMovableGetTextFromRangefeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableGetTextFromRange"));
        byte[] r7 = new FuncParamsX7ebda7b1245bc0ff(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 5898691001801595135L, r7);     // Catch: RuntimeException -> L6
        String r12 = ((FuncReturnX0bf8b5c665c57f35) FuncReturnX0bf8b5c665c57f35.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestRenderStream-feOb9K0, reason: not valid java name */
    public static final byte[] m481ffiRequestRenderStreamfeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestRenderStream"));
        byte[] r7 = new FuncParamsX710fe409271b5ca7(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -903297340059201436L, r7);     // Catch: RuntimeException -> L6
        ByteString r12 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestRenderStreamInTextApi-feOb9K0, reason: not valid java name */
    public static final byte[] m482ffiRequestRenderStreamInTextApifeOb9K0(int r9, int r10) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestRenderStreamInTextApi"));
        byte[] r7 = new FuncParamsX710fe409271b5ca7(Integer.valueOf(r9), Integer.valueOf(r10), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r11 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -6344088251942875036L, r7);     // Catch: RuntimeException -> L6
        ByteString r12 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r11)).ret;
        Intrinsics.checkNotNull(r12);
        return r12.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r13 = DefaultCallStatusErrorHandler.INSTANCE;
        String r14 = e.getMessage();
        Intrinsics.checkNotNull(r14);
        throw r13.report$lark_markdown_render_android_release(new UnhandledException(r14));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableCallPickCaret-zly0blg, reason: not valid java name */
    public static final void m466ffiMovableCallPickCaretzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallPickCaret"));
        byte[] r7 = new FuncParamsXb93ca91530509a90(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -8409138205150284028L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r13 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r12);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableCallSelectAll-zly0blg, reason: not valid java name */
    public static final void m467ffiMovableCallSelectAllzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallSelectAll"));
        byte[] r7 = new FuncParamsX3bb861e377637789(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 4991691148903446276L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r13 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r12);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableCallTouchCancelled-zly0blg, reason: not valid java name */
    public static final void m468ffiMovableCallTouchCancelledzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallTouchCancelled"));
        byte[] r7 = new FuncParamsX3bb861e377637789(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 6439248187404973828L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r13 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r12);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableGetIslandMarkdown-zly0blg, reason: not valid java name */
    public static final String m470ffiMovableGetIslandMarkdownzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableGetIslandMarkdown"));
        byte[] r7 = new FuncParamsX47a9fcbf1062f608(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -4404861851584037773L, r7);     // Catch: RuntimeException -> L6
        String r13 = ((FuncReturnX0bf8b5c665c57f35) FuncReturnX0bf8b5c665c57f35.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableRequestAttachmentsDiff-zly0blg, reason: not valid java name */
    public static final byte[] m473ffiMovableRequestAttachmentsDiffzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRequestAttachmentsDiff"));
        byte[] r7 = new FuncParamsX3f2cec9ef12393f7(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 2872120452017210583L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableRequestCarets-zly0blg, reason: not valid java name */
    public static final List<FfiCaret> m474ffiMovableRequestCaretszly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRequestCarets"));
        byte[] r7 = new FuncParamsX3bb861e377637789(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L9
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L9
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 3317725461534828435L, r7);     // Catch: RuntimeException -> L9
        List r13 = ((FuncReturnX899e98b47a458199) FuncReturnX899e98b47a458199.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        List r14 = r13;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r17 = r14.iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        lark_markdown_render.proto.FfiCaret r18 = (lark_markdown_render.proto.FfiCaret) r17.next();
        Intrinsics.checkNotNull(r18);
        r16.add(into(r18));
        goto L6
    L8:
        return r16;
    L9:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        DefaultCallStatusErrorHandler r19 = DefaultCallStatusErrorHandler.INSTANCE;
        String r20 = e.getMessage();
        Intrinsics.checkNotNull(r20);
        throw r19.report$lark_markdown_render_android_release(new UnhandledException(r20));
    L15:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableRequestIslandsDiff-zly0blg, reason: not valid java name */
    public static final byte[] m475ffiMovableRequestIslandsDiffzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRequestIslandsDiff"));
        byte[] r7 = new FuncParamsX3f2cec9ef12393f7(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -555738748451633961L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableRsInitDeviceInfo-OzbTU-A, reason: not valid java name */
    public static final void m476ffiMovableRsInitDeviceInfoOzbTUA(int r9, boolean r10, float r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableRsInitDeviceInfo"));
        byte[] r7 = new FuncParamsX9cdbe2b96ec2b9d9(Integer.valueOf(r9), Boolean.valueOf(r10), Float.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 919692699209640760L, r7);     // Catch: RuntimeException -> L6
        MoltenContextExtra r13 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r12);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestIslandHighlightStream-zly0blg, reason: not valid java name */
    public static final byte[] m478ffiRequestIslandHighlightStreamzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestIslandHighlightStream"));
        byte[] r7 = new FuncParamsXbefd9658286129cf(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -6945591353490217L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestIslandRenderStream-zly0blg, reason: not valid java name */
    public static final byte[] m479ffiRequestIslandRenderStreamzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestIslandRenderStream"));
        byte[] r7 = new FuncParamsX4314480f8beb223c(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, -2877228344999492393L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestIslandRenderStreamInTextApi-zly0blg, reason: not valid java name */
    public static final byte[] m480ffiRequestIslandRenderStreamInTextApizly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestIslandRenderStreamInTextApi"));
        byte[] r7 = new FuncParamsX4314480f8beb223c(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 1930141107897681111L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiRequestRenderStreamWithWidth-zly0blg, reason: not valid java name */
    public static final byte[] m483ffiRequestRenderStreamWithWidthzly0blg(int r9, int r10, int r11) {
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r1 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiRequestRenderStreamWithWidth"));
        byte[] r7 = new FuncParamsX302a81fd1e3f62ae(Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), r1).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r7);     // Catch: RuntimeException -> L6
        byte[] r12 = r0.molten_ffi_lark_markdown_render_call(r2, 0, 8343635103215174871L, r7);     // Catch: RuntimeException -> L6
        ByteString r13 = ((FuncReturnXb05c0e03c1bfe022) FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r12)).ret;
        Intrinsics.checkNotNull(r13);
        return r13.toByteArray();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r14 = DefaultCallStatusErrorHandler.INSTANCE;
        String r16 = e.getMessage();
        Intrinsics.checkNotNull(r16);
        throw r14.report$lark_markdown_render_android_release(new UnhandledException(r16));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    public static final MovableDocumentInfo ffiParseMarkdownForClient(String r10, float r11, MovableRenderConfig r12, MovableRenderUrlPreviewInlines r13) {
        Intrinsics.checkNotNullParameter(r10, "markdown");
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r6 = r0.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiParseMarkdownForClient"));
        Float r3 = Float.valueOf(r11);
        if (r12 == null) goto L5;
        lark_markdown_render.proto.MovableRenderConfig r4 = r12.into();
    L6:
        if (r13 == null) goto L8;
        lark_markdown_render.proto.MovableRenderUrlPreviewInlines r5 = r13.into();
    L9:
        byte[] r8 = new FuncParamsX128e7aed481f35b9(r10, r3, r4, r5, r6).encode();
        long r2 = r0.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L15
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L15
        lark_markdown_render.proto.MovableDocumentInfo r1 = ((FuncReturnXcbb624c70e011a12) FuncReturnXcbb624c70e011a12.ADAPTER.decode(r0.molten_ffi_lark_markdown_render_call(r2, 0, -6554220030954879231L, r8))).ret;
        if (r1 != null) goto L14;
        return null;
    L14:
        return into(r1);
    L15:
        e = move-exception;
        if (e.getMessage() == null) goto L21;
        DefaultCallStatusErrorHandler r7 = DefaultCallStatusErrorHandler.INSTANCE;
        String r9 = e.getMessage();
        Intrinsics.checkNotNull(r9);
        throw r7.report$lark_markdown_render_android_release(new UnhandledException(r9));
    L21:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: ffiMovableCallDoubleTap-6Thg8X8, reason: not valid java name */
    public static final void m464ffiMovableCallDoubleTap6Thg8X8(int r16, int r17, int r18, float r19, float r20) {
        MoltenFfiLibLarkMarkdownRender.Companion r1 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r110 = r1.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallDoubleTap"));
        byte[] r8 = new FuncParamsX263d27dbec1bcaad(Integer.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), Float.valueOf(r19), Float.valueOf(r20), r110).encode();
        long r2 = r1.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L6
        byte[] r0 = r1.molten_ffi_lark_markdown_render_call(r2, 0, -7525477798055282876L, r8);     // Catch: RuntimeException -> L6
        MoltenContextExtra r3 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r0);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r4 = DefaultCallStatusErrorHandler.INSTANCE;
        String r5 = e.getMessage();
        Intrinsics.checkNotNull(r5);
        throw r4.report$lark_markdown_render_android_release(new UnhandledException(r5));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableCallLongPress-6Thg8X8, reason: not valid java name */
    public static final void m465ffiMovableCallLongPress6Thg8X8(int r16, int r17, int r18, float r19, float r20) {
        MoltenFfiLibLarkMarkdownRender.Companion r1 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r110 = r1.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallLongPress"));
        byte[] r8 = new FuncParamsX263d27dbec1bcaad(Integer.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), Float.valueOf(r19), Float.valueOf(r20), r110).encode();
        long r2 = r1.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L6
        byte[] r0 = r1.molten_ffi_lark_markdown_render_call(r2, 0, -358678712619403452L, r8);     // Catch: RuntimeException -> L6
        MoltenContextExtra r3 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r0);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r4 = DefaultCallStatusErrorHandler.INSTANCE;
        String r5 = e.getMessage();
        Intrinsics.checkNotNull(r5);
        throw r4.report$lark_markdown_render_android_release(new UnhandledException(r5));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: ffiMovableCallTouchMove-6Thg8X8, reason: not valid java name */
    public static final void m469ffiMovableCallTouchMove6Thg8X8(int r16, int r17, int r18, float r19, float r20) {
        MoltenFfiLibLarkMarkdownRender.Companion r1 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r110 = r1.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "ffiMovableCallTouchMove"));
        byte[] r8 = new FuncParamsX263d27dbec1bcaad(Integer.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), Float.valueOf(r19), Float.valueOf(r20), r110).encode();
        long r2 = r1.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L6
        byte[] r0 = r1.molten_ffi_lark_markdown_render_call(r2, 0, 4376055430188857156L, r8);     // Catch: RuntimeException -> L6
        MoltenContextExtra r3 = (MoltenContextExtra) MoltenContextExtra.ADAPTER.decode(r0);
        return;
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r4 = DefaultCallStatusErrorHandler.INSTANCE;
        String r5 = e.getMessage();
        Intrinsics.checkNotNull(r5);
        throw r4.report$lark_markdown_render_android_release(new UnhandledException(r5));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }

    /* JADX INFO: renamed from: triggerClick-6Thg8X8, reason: not valid java name */
    public static final boolean m484triggerClick6Thg8X8(int r16, int r17, int r18, float r19, float r20) {
        MoltenFfiLibLarkMarkdownRender.Companion r1 = MoltenFfiLibLarkMarkdownRender.Companion;
        ByteString r110 = r1.buildExtra(new InvokeHookInfo("lark_markdown_render", -4808240200122791624L, 1559071032, null, "triggerClick"));
        byte[] r8 = new FuncParamsXf48f33eae5ff1bb1(Integer.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), Float.valueOf(r19), Float.valueOf(r20), r110).encode();
        long r2 = r1.getRuntime$lark_markdown_render_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r8);     // Catch: RuntimeException -> L6
        byte[] r0 = r1.molten_ffi_lark_markdown_render_call(r2, 0, 5879005491023819312L, r8);     // Catch: RuntimeException -> L6
        Boolean r3 = ((FuncReturnX3dc8b8542df1cbb1) FuncReturnX3dc8b8542df1cbb1.ADAPTER.decode(r0)).ret;
        Intrinsics.checkNotNull(r3);
        return r3.booleanValue();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r4 = DefaultCallStatusErrorHandler.INSTANCE;
        String r5 = e.getMessage();
        Intrinsics.checkNotNull(r5);
        throw r4.report$lark_markdown_render_android_release(new UnhandledException(r5));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$lark_markdown_render_android_release(new UnhandledException("Rust panic"));
    }
}
