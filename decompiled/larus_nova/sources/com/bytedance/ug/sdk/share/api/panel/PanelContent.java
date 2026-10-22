package com.bytedance.ug.sdk.share.api.panel;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel;
import in7.e;
import in7.f;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class PanelContent implements Serializable {
    private Activity mActivity;
    private String mCancelText;
    private boolean mIsDisableGetShareInfo;
    private e mOnPanelActionCallback;
    private ISharePanel mPanel;
    private String mPanelId;
    private f mPanelItemsCallback;
    private JSONObject mRequestData;
    private String mResourceId;
    private ShareContent mShareContent;

    public static /* synthetic */ class a {
    }

    public e getOnPanelActionCallback() {
        return null;
    }

    public ISharePanel getPanel() {
        return null;
    }

    public f getPanelItemsCallback() {
        return null;
    }

    public boolean isDisableGetShareInfo() {
        if (eo7.a.b.f473353a.f473348v == false) goto L7;
        return true;
    L7:
        return this.mIsDisableGetShareInfo;
    }

    private PanelContent() {
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public String getCancelText() {
        return this.mCancelText;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public JSONObject getRequestData() {
        return this.mRequestData;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public ShareContent getShareContent() {
        return this.mShareContent;
    }

    public /* synthetic */ PanelContent(a r100) {
        this();
    }

    public static /* synthetic */ f access$1002(PanelContent r100, f r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ Activity access$102(PanelContent r100, Activity r101) {
        r100.mActivity = r101;
        return r101;
    }

    public static /* synthetic */ ISharePanel access$202(PanelContent r100, ISharePanel r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ e access$302(PanelContent r100, e r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ ShareContent access$402(PanelContent r100, ShareContent r101) {
        r100.mShareContent = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(PanelContent r100, String r101) {
        r100.mCancelText = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(PanelContent r100, String r101) {
        r100.mPanelId = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(PanelContent r100, String r101) {
        r100.mResourceId = r101;
        return r101;
    }

    public static /* synthetic */ JSONObject access$802(PanelContent r100, JSONObject r101) {
        r100.mRequestData = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(PanelContent r100, boolean r101) {
        r100.mIsDisableGetShareInfo = r101;
        return r101;
    }
}
