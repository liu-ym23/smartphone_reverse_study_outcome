package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareIconStyle[] f216535a = null;

        static {
            ShareIconStyle r100 = new ShareIconStyle("INSET", 0);
            INSET = r100;
            ShareIconStyle r101 = new ShareIconStyle("FILL", 1);
            FILL = r101;
            f216535a = new ShareIconStyle[]{r100, r101};
        }

        public static ShareIconStyle[] values() {
            return (ShareIconStyle[]) f216535a.clone();
        }

        public static ShareIconStyle valueOf(String r100) {
            return (ShareIconStyle) r27.a.a(ShareIconStyle.class, r100);
        }

        public ShareIconStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        boolean a(Context r100, ShareItemModel r101, com.bytedance.ee.bear.share.g r102);
    }

    public ShareItemModel copy() {
        ShareItemModel r100 = new ShareItemModel(this.itemId);
        r100.type = this.type;
        r100.description = this.description;
        r100.state = this.state;
        r100.iconResId = this.iconResId;
        r100.iconUrl = this.iconUrl;
        r100.iconKey = this.iconKey;
        r100.srcTint = this.srcTint;
        r100.shareItemBackground = this.shareItemBackground;
        r100.scaleType = this.scaleType;
        r100.shareIconStyle = this.shareIconStyle;
        r100.docType = this.docType;
        r100.docToken = this.docToken;
        r100.onClickedListener = this.onClickedListener;
        r100.itemStateLiveData = this.itemStateLiveData;
        return r100;
    }

    public boolean isClickable() {
        ShareState r100 = this.state;
        if (r100 != ShareState.NOT_SHOW) goto L5;
    L11:
        return false;
    L5:
        if (r100 == ShareState.NOT_CLICK) goto L11;
        if (r100 == ShareState.ADMIN_NOT_CLICK) goto L11;
        if (r100 == ShareState.CAC_NOT_CLICK) goto L11;
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

    public ShareItemModel(ShareType r100) {
        this.itemStateLiveData = new MutableLiveData(ShareState.NOT_SHOW);
        this.srcTint = Integer.MIN_VALUE;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.shareIconStyle = ShareIconStyle.INSET;
        this.itemId = r100.getItemId();
        this.type = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setDocToken(String r100) {
        this.docToken = r100;
    }

    public void setDocType(int r100) {
        this.docType = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setIconResId(int r100) {
        this.iconResId = r100;
    }

    public void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public void setItemId(String r100) {
        this.itemId = r100;
        this.type = null;
    }

    public void setOnClickedListener(a r100) {
        this.onClickedListener = r100;
    }

    public void setScaleType(ImageView.ScaleType r100) {
        this.scaleType = r100;
    }

    public void setShareIconStyle(ShareIconStyle r100) {
        this.shareIconStyle = r100;
        if (r100 != ShareIconStyle.INSET) goto L6;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        return;
    L6:
        if (r100 != ShareIconStyle.FILL) goto L10;
        this.scaleType = ImageView.ScaleType.FIT_CENTER;
        return;
    }

    public void setShareItemBackground(int r100) {
        this.shareItemBackground = r100;
    }

    public void setSrcTint(int r100) {
        this.srcTint = r100;
    }

    public void setState(ShareState r100) {
        this.state = r100;
    }

    public void setType(ShareType r100) {
        this.type = r100;
        this.itemId = r100.getItemId();
    }

    public ShareItemModel(String r100) {
        this.itemStateLiveData = new MutableLiveData(ShareState.NOT_SHOW);
        this.srcTint = Integer.MIN_VALUE;
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.shareIconStyle = ShareIconStyle.INSET;
        this.itemId = r100;
    }
}
