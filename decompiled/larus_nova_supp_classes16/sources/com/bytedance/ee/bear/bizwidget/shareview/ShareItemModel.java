package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShareItemModel implements NonProguard {
    public static final int SRC_TINT_UNDEFINED = Integer.MIN_VALUE;
    private String description;
    private String docToken;
    private int docType;
    private String iconKey;
    private int iconResId;
    private String iconUrl;
    private String itemId;
    private MutableLiveData<ShareState> itemStateLiveData;
    private a onClickedListener;
    private ImageView.ScaleType scaleType;
    private ShareIconStyle shareIconStyle;
    private int shareItemBackground;
    private int srcTint;
    private ShareState state;
    private ShareType type;

    public static final enum ShareIconStyle extends Enum<ShareIconStyle> {
        public static final ShareIconStyle FILL = null;
        public static final ShareIconStyle INSET = null;
        public static final /* synthetic */ ShareIconStyle[] a = null;

        static {
            ShareIconStyle r0 = new ShareIconStyle("INSET", 0);
            INSET = r0;
            ShareIconStyle r1 = new ShareIconStyle("FILL", 1);
            FILL = r1;
            a = new ShareIconStyle[]{r0, r1};
        }

        public static ShareIconStyle[] values() {
            return (ShareIconStyle[]) a.clone();
        }

        public static ShareIconStyle valueOf(String r1) {
            return (ShareIconStyle) r27.a.a(ShareIconStyle.class, r1);
        }

        public ShareIconStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        boolean a(Context r1, ShareItemModel r2, com.bytedance.ee.bear.share.g r3);
    }

    public ShareItemModel copy() {
        ShareItemModel r0 = new ShareItemModel(this.itemId);
        r0.type = this.type;
        r0.description = this.description;
        r0.state = this.state;
        r0.iconResId = this.iconResId;
        r0.iconUrl = this.iconUrl;
        r0.iconKey = this.iconKey;
        r0.srcTint = this.srcTint;
        r0.shareItemBackground = this.shareItemBackground;
        r0.scaleType = this.scaleType;
        r0.shareIconStyle = this.shareIconStyle;
        r0.docType = this.docType;
        r0.docToken = this.docToken;
        r0.onClickedListener = this.onClickedListener;
        r0.itemStateLiveData = this.itemStateLiveData;
        return r0;
    }

    public boolean isClickable() {
        ShareState r0 = this.state;
        if (r0 != ShareState.NOT_SHOW) goto L5;
    L11:
        return false;
    L5:
        if (r0 == ShareState.NOT_CLICK) goto L11;
        if (r0 == ShareState.ADMIN_NOT_CLICK) goto L11;
        if (r0 == ShareState.CAC_NOT_CLICK) goto L11;
        return true;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDocToken() {
        return this.docToken;
    }

    public int getDocType() {
        return this.docType;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getItemId() {
        return this.itemId;
    }

    public a getOnClickedListener() {
        return this.onClickedListener;
    }

    public ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public ShareIconStyle getShareIconStyle() {
        return this.shareIconStyle;
    }

    public int getShareItemBackground() {
        return this.shareItemBackground;
    }

    public int getSrcTint() {
        return this.srcTint;
    }

    public ShareState getState() {
        return this.state;
    }

    public ShareType getType() {
        return this.type;
    }

    public MutableLiveData<ShareState> itemStateLiveData() {
        return this.itemStateLiveData;
    }

    public ShareItemModel(ShareType r3) {
        this.itemStateLiveData = new MutableLiveData(ShareState.NOT_SHOW);
        this.srcTint = SRC_TINT_UNDEFINED;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.shareIconStyle = ShareIconStyle.INSET;
        this.itemId = r3.getItemId();
        this.type = r3;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setDocToken(String r1) {
        this.docToken = r1;
    }

    public void setDocType(int r1) {
        this.docType = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setIconResId(int r1) {
        this.iconResId = r1;
    }

    public void setIconUrl(String r1) {
        this.iconUrl = r1;
    }

    public void setItemId(String r1) {
        this.itemId = r1;
        this.type = null;
    }

    public void setOnClickedListener(a r1) {
        this.onClickedListener = r1;
    }

    public void setScaleType(ImageView.ScaleType r1) {
        this.scaleType = r1;
    }

    public void setShareIconStyle(ShareIconStyle r2) {
        this.shareIconStyle = r2;
        if (r2 != ShareIconStyle.INSET) goto L6;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        return;
    L6:
        if (r2 != ShareIconStyle.FILL) goto L10;
        this.scaleType = ImageView.ScaleType.FIT_CENTER;
        return;
    }

    public void setShareItemBackground(int r1) {
        this.shareItemBackground = r1;
    }

    public void setSrcTint(int r1) {
        this.srcTint = r1;
    }

    public void setState(ShareState r1) {
        this.state = r1;
    }

    public void setType(ShareType r1) {
        this.type = r1;
        this.itemId = r1.getItemId();
    }

    public ShareItemModel(String r3) {
        this.itemStateLiveData = new MutableLiveData(ShareState.NOT_SHOW);
        this.srcTint = SRC_TINT_UNDEFINED;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.shareIconStyle = ShareIconStyle.INSET;
        this.itemId = r3;
    }
}
