package com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model;

import android.text.TextUtils;
import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.a;
import java.io.Serializable;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class RedPacketModel implements Serializable {
    private String mConfirmUrl;
    private RedPacketModelDataSource mDataSource;
    private String mFrom;
    private boolean mIsPop;
    private String mRawData;
    private int mRewardAmount;
    private int mTaskStatus;

    public static RedPacketModel getDefaultModel() {
        if (m.a.f271349a.f271342j == null) goto L5;
        String r100 = null;
    L6:
        a.c("LuckyCatConfigManager", "getRedPacketDialogDefaultData:" + r100);
        RedPacketModel r101 = new RedPacketModel();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r101;
    L12:
        RedPacketModel r102 = extract(new JSONObject(r100));     // Catch: JSONException -> L11
        r102.setDataSource(RedPacketModelDataSource.LOCAL);     // Catch: JSONException -> L11
        return r102;
    L11:
        return r101;
    L5:
        r100 = "";
        goto L6
    }

    public RedPacketModel() {
        this.mDataSource = RedPacketModelDataSource.SERVER;
    }

    public String getConfirmUrl() {
        return this.mConfirmUrl;
    }

    public RedPacketModelDataSource getDataSource() {
        return this.mDataSource;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getRawData() {
        return this.mRawData;
    }

    public int getRewardAmount() {
        return this.mRewardAmount;
    }

    public int getTaskStatus() {
        return this.mTaskStatus;
    }

    public boolean isPop() {
        return this.mIsPop;
    }

    public static RedPacketModel extract(JSONObject r100) {
        if (r100 == null) goto L4;
        RedPacketModel r101 = new RedPacketModel();
        r101.mIsPop = r100.optBoolean("is_pop", false);
        r101.mRewardAmount = r100.optInt("amount", 3200);
        r101.mTaskStatus = r100.optInt("task_status", 0);
        r101.mConfirmUrl = r100.optString("confirm_url", m.a.f271349a.j() + "task/done/redpack");
        r101.mRawData = r100.toString();
        return r101;
    L4:
        return getDefaultModel();
    }

    public static String getFormatPrice(int r100) {
        if ((r100 % 100) != 0) goto L7;
        return String.valueOf(r100 / 100);
    L7:
        if ((r100 % 10) != 0) goto L11;
        return new DecimalFormat(GLUtils.VERSION_UNKNOWN).format(r100 / 100.0f);
    L11:
        return new DecimalFormat("0.00").format(r100 / 100.0f);
    }

    public void setConfirmUrl(String r100) {
        this.mConfirmUrl = r100;
    }

    public void setDataSource(RedPacketModelDataSource r100) {
        this.mDataSource = r100;
    }

    public void setFrom(String r100) {
        this.mFrom = r100;
    }

    public void setIsPop(boolean r100) {
        this.mIsPop = r100;
    }

    public void setRawData(String r100) {
        this.mRawData = r100;
    }

    public void setRewardAmount(int r100) {
        this.mRewardAmount = r100;
    }

    public void setTaskStatus(int r100) {
        this.mTaskStatus = r100;
    }

    public static RedPacketModel extract(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        return extract(new JSONObject(r100));
    L7:
        return null;
    }
}
