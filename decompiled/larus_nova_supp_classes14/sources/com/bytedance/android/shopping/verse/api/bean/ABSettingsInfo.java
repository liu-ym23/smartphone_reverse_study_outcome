package com.bytedance.android.shopping.verse.api.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/bean/ABSettingsInfo;", "Ljava/io/Serializable;", "()V", "abSettingsInfo", "", "Lcom/bytedance/android/shopping/verse/api/bean/ABSetting;", "getAbSettingsInfo", "()Ljava/util/List;", "setAbSettingsInfo", "(Ljava/util/List;)V", "mockEnable", "", "getMockEnable", "()Ljava/lang/Boolean;", "setMockEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "needRestartToApplyMock", "getNeedRestartToApplyMock", "setNeedRestartToApplyMock", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ABSettingsInfo implements Serializable {

    @SerializedName("abSettingsInfo")
    private List<ABSetting> abSettingsInfo;

    @SerializedName("mockEnable")
    private Boolean mockEnable;

    @SerializedName("needRestartToApplyMock")
    private Boolean needRestartToApplyMock;

    public ABSettingsInfo() {
    }

    public final List<ABSetting> getAbSettingsInfo() {
        return this.abSettingsInfo;
    }

    public final Boolean getMockEnable() {
        return this.mockEnable;
    }

    public final Boolean getNeedRestartToApplyMock() {
        return this.needRestartToApplyMock;
    }

    public final void setAbSettingsInfo(List<ABSetting> r1) {
        this.abSettingsInfo = r1;
    }

    public final void setMockEnable(Boolean r1) {
        this.mockEnable = r1;
    }

    public final void setNeedRestartToApplyMock(Boolean r1) {
        this.needRestartToApplyMock = r1;
    }
}
