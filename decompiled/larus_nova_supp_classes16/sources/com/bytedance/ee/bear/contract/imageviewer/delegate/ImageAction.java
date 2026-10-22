package com.bytedance.ee.bear.contract.imageviewer.delegate;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/contract/imageviewer/delegate/ImageAction;", "", JSEventListener.ACTION, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "NEXT", "PREVIOUS", "ZOOM_IN", "ZOOM_OUT", "QUICK_ZOOM", "IMAGE_SELECTION_CLICK", "features-image-viewer-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageAction extends Enum<ImageAction> {
    public static final ImageAction IMAGE_SELECTION_CLICK = null;
    public static final ImageAction NEXT = null;
    public static final ImageAction PREVIOUS = null;
    public static final ImageAction QUICK_ZOOM = null;
    public static final ImageAction ZOOM_IN = null;
    public static final ImageAction ZOOM_OUT = null;
    public static final /* synthetic */ ImageAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String action;

    public static EnumEntries<ImageAction> getEntries() {
        return b;
    }

    static {
        ImageAction r0 = new ImageAction("NEXT", 0, "next");
        NEXT = r0;
        ImageAction r1 = new ImageAction("PREVIOUS", 1, "prev");
        PREVIOUS = r1;
        ImageAction r2 = new ImageAction("ZOOM_IN", 2, "zoom_in");
        ZOOM_IN = r2;
        ImageAction r4 = new ImageAction("ZOOM_OUT", 3, "zoom_out");
        ZOOM_OUT = r4;
        ImageAction r6 = new ImageAction("QUICK_ZOOM", 4, "quick_zoom");
        QUICK_ZOOM = r6;
        ImageAction r8 = new ImageAction("IMAGE_SELECTION_CLICK", 5, "image_selection_click");
        IMAGE_SELECTION_CLICK = r8;
        ImageAction[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static ImageAction[] values() {
        return (ImageAction[]) a.clone();
    }

    public final String getAction() {
        return this.action;
    }

    public static ImageAction valueOf(String r1) {
        return (ImageAction) a.a(ImageAction.class, r1);
    }

    public ImageAction(String r1, int r2, String r3) {
        super(r1, r2);
        this.action = r3;
    }
}
