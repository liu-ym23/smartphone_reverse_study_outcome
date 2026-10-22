package com.bytedance.ee.bear.middleground.permission.export.ui.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R>\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "regExpMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getRegExpMap", "()Ljava/util/HashMap;", "setRegExpMap", "(Ljava/util/HashMap;)V", "checkTips", "Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$CheckTips;", "getCheckTips", "()Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$CheckTips;", "setCheckTips", "(Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$CheckTips;)V", "pwdLevel", "Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$PwdLevel;", "getPwdLevel", "()Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$PwdLevel;", "setPwdLevel", "(Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$PwdLevel;)V", "CheckTips", "PwdLevel", "RuleArray", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PasswordCheckRules extends Result<Serializable> implements NonProguard {

    @SerializedName("pwd_check_tips")
    private CheckTips checkTips;

    @SerializedName("pwd_level")
    private PwdLevel pwdLevel;

    @SerializedName("reg_exp_map")
    private HashMap<String, String> regExpMap;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$CheckTips;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "matchTips", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$RuleArray;", "Lkotlin/collections/ArrayList;", "getMatchTips", "()Ljava/util/ArrayList;", "setMatchTips", "(Ljava/util/ArrayList;)V", "notMatchTips", "getNotMatchTips", "setNotMatchTips", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckTips implements NonProguard {

        @SerializedName("match_tips")
        private ArrayList<RuleArray> matchTips;

        @SerializedName("not_match_tips")
        private ArrayList<RuleArray> notMatchTips;

        public CheckTips() {
        }

        public final ArrayList<RuleArray> getMatchTips() {
            return this.matchTips;
        }

        public final ArrayList<RuleArray> getNotMatchTips() {
            return this.notMatchTips;
        }

        public final void setMatchTips(ArrayList<RuleArray> r100) {
            this.matchTips = r100;
        }

        public final void setNotMatchTips(ArrayList<RuleArray> r100) {
            this.notMatchTips = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR2\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$PwdLevel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "strongRules", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$RuleArray;", "Lkotlin/collections/ArrayList;", "getStrongRules", "()Ljava/util/ArrayList;", "setStrongRules", "(Ljava/util/ArrayList;)V", "middleRules", "getMiddleRules", "setMiddleRules", "weakRules", "getWeakRules", "setWeakRules", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PwdLevel implements NonProguard {

        @SerializedName("middle")
        private ArrayList<RuleArray> middleRules;

        @SerializedName("strong")
        private ArrayList<RuleArray> strongRules;

        @SerializedName("weak")
        private ArrayList<RuleArray> weakRules;

        public PwdLevel() {
        }

        public final ArrayList<RuleArray> getMiddleRules() {
            return this.middleRules;
        }

        public final ArrayList<RuleArray> getStrongRules() {
            return this.strongRules;
        }

        public final ArrayList<RuleArray> getWeakRules() {
            return this.weakRules;
        }

        public final void setMiddleRules(ArrayList<RuleArray> r100) {
            this.middleRules = r100;
        }

        public final void setStrongRules(ArrayList<RuleArray> r100) {
            this.strongRules = r100;
        }

        public final void setWeakRules(ArrayList<RuleArray> r100) {
            this.weakRules = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/PasswordCheckRules$RuleArray;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "matchReq", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMatchReq", "()Ljava/util/ArrayList;", "setMatchReq", "(Ljava/util/ArrayList;)V", "notMatchReq", "getNotMatchReq", "setNotMatchReq", "msg", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RuleArray implements NonProguard {

        @SerializedName("match_reg")
        private ArrayList<String> matchReq;
        private String msg;

        @SerializedName("not_match_reg")
        private ArrayList<String> notMatchReq;

        public RuleArray() {
            this.msg = "";
        }

        public final ArrayList<String> getMatchReq() {
            return this.matchReq;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final ArrayList<String> getNotMatchReq() {
            return this.notMatchReq;
        }

        public final void setMatchReq(ArrayList<String> r100) {
            this.matchReq = r100;
        }

        public final void setMsg(String r100) {
            this.msg = r100;
        }

        public final void setNotMatchReq(ArrayList<String> r100) {
            this.notMatchReq = r100;
        }
    }

    public PasswordCheckRules() {
    }

    public final CheckTips getCheckTips() {
        return this.checkTips;
    }

    public final PwdLevel getPwdLevel() {
        return this.pwdLevel;
    }

    public final HashMap<String, String> getRegExpMap() {
        return this.regExpMap;
    }

    public final void setCheckTips(CheckTips r100) {
        this.checkTips = r100;
    }

    public final void setPwdLevel(PwdLevel r100) {
        this.pwdLevel = r100;
    }

    public final void setRegExpMap(HashMap<String, String> r100) {
        this.regExpMap = r100;
    }
}
