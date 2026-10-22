package com.ss.android.lark.picker.config;

import com.bytedance.lark.pb.basic.v1.ActionType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001e¨\u0006&"}, d2 = {"Lcom/ss/android/lark/picker/config/ChatterExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "isReturnInChatId", "", "()Ljava/lang/String;", "setReturnInChatId", "(Ljava/lang/String;)V", "isReturnInTeamId", "setReturnInTeamId", "isEnableFuzzySearch", "", "()Ljava/lang/Boolean;", "setEnableFuzzySearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isReturnRelationTag", "()Z", "setReturnRelationTag", "(Z)V", "existsEnterpriseEmail", "getExistsEnterpriseEmail", "setExistsEnterpriseEmail", "inUserIds", "", "", "getInUserIds", "()Ljava/util/List;", "setInUserIds", "(Ljava/util/List;)V", "appendUserTeam", "getAppendUserTeam", "setAppendUserTeam", "isReturnPermissionsResult", "Lcom/bytedance/lark/pb/basic/v1/ActionType;", "isReturnPermissionsResult$picker_release", "setReturnPermissionsResult$picker_release", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterExtra implements Extra {
    private boolean appendUserTeam;
    private Boolean existsEnterpriseEmail;
    private List<Long> inUserIds;
    private Boolean isEnableFuzzySearch;
    private String isReturnInChatId;
    private String isReturnInTeamId;
    private transient List<? extends ActionType> isReturnPermissionsResult;
    private boolean isReturnRelationTag;

    public ChatterExtra() {
        this.isReturnRelationTag = true;
    }

    public final boolean getAppendUserTeam() {
        return this.appendUserTeam;
    }

    public final Boolean getExistsEnterpriseEmail() {
        return this.existsEnterpriseEmail;
    }

    public final List<Long> getInUserIds() {
        return this.inUserIds;
    }

    public final Boolean isEnableFuzzySearch() {
        return this.isEnableFuzzySearch;
    }

    public final String isReturnInChatId() {
        return this.isReturnInChatId;
    }

    public final String isReturnInTeamId() {
        return this.isReturnInTeamId;
    }

    public final List<ActionType> isReturnPermissionsResult$picker_release() {
        return this.isReturnPermissionsResult;
    }

    public final boolean isReturnRelationTag() {
        return this.isReturnRelationTag;
    }

    public final void setAppendUserTeam(boolean r100) {
        this.appendUserTeam = r100;
    }

    public final void setEnableFuzzySearch(Boolean r100) {
        this.isEnableFuzzySearch = r100;
    }

    public final void setExistsEnterpriseEmail(Boolean r100) {
        this.existsEnterpriseEmail = r100;
    }

    public final void setInUserIds(List<Long> r100) {
        this.inUserIds = r100;
    }

    public final void setReturnInChatId(String r100) {
        this.isReturnInChatId = r100;
    }

    public final void setReturnInTeamId(String r100) {
        this.isReturnInTeamId = r100;
    }

    public final void setReturnPermissionsResult$picker_release(List<? extends ActionType> r100) {
        this.isReturnPermissionsResult = r100;
    }

    public final void setReturnRelationTag(boolean r100) {
        this.isReturnRelationTag = r100;
    }
}
