package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ*\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "", "eventClick", "", "instanceId", "Lkotlin/UInt;", "schema", "", WsConstants.KEY_PAYLOAD, "eventClick-OzbTU-A", "(ILjava/lang/String;Ljava/lang/String;)V", "getFontPrefixPathCandidates", "", "getScrollIslandScrollOffset", "", "canvasId", "islandId", "getScrollIslandScrollOffset-feOb9K0", "(II)Ljava/util/List;", "markHighlightUpdate", "x", "y", "width", "height", "markHighlightUpdate-iyaXS9w", "(IFFFF)V", "measureAttachment", "typeId", "containerWidth", "propertyString", "measureAttachment-OzbTU-A", "(IFLjava/lang/String;)Ljava/util/List;", "registerFont", "name", "path", "ttcIndex", "registerFont-jXDDuk8", "(Ljava/lang/String;Ljava/lang/String;I)V", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MovableCallback {
    /* JADX INFO: renamed from: eventClick-OzbTU-A, reason: not valid java name */
    void mo8414eventClickOzbTUA(int r100, String r101, String r102);

    List<String> getFontPrefixPathCandidates();

    /* JADX INFO: renamed from: getScrollIslandScrollOffset-feOb9K0, reason: not valid java name */
    List<Float> mo8415getScrollIslandScrollOffsetfeOb9K0(int r100, int r101);

    /* JADX INFO: renamed from: markHighlightUpdate-iyaXS9w, reason: not valid java name */
    void mo8416markHighlightUpdateiyaXS9w(int r100, float r101, float r102, float r103, float r104);

    /* JADX INFO: renamed from: measureAttachment-OzbTU-A, reason: not valid java name */
    List<Float> mo8417measureAttachmentOzbTUA(int r100, float r101, String r102);

    /* JADX INFO: renamed from: registerFont-jXDDuk8, reason: not valid java name */
    void mo8418registerFontjXDDuk8(String r100, String r101, int r102);
}
