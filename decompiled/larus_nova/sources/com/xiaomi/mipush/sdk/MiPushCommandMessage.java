package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class MiPushCommandMessage implements PushMessageHandler.a {
    private static final String KEY_AUTO_MARK_PKGS = "autoMarkPkgs";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_COMMAND = "command";
    private static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
    private static final String KEY_REASON = "reason";
    private static final String KEY_RESULT_CODE = "resultCode";
    private static final long serialVersionUID = 1;
    private List<String> autoMarkPkgs;
    private String category;
    private String command;
    private List<String> commandArguments;
    private String reason;
    private long resultCode;

    public MiPushCommandMessage() {
    }

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putString("command", this.command);
        r100.putLong("resultCode", this.resultCode);
        r100.putString("reason", this.reason);
        List<String> r101 = this.commandArguments;
        if (r101 == null) goto L5;
        r100.putStringArrayList(KEY_COMMAND_ARGUMENTS, (ArrayList) r101);
    L5:
        r100.putString("category", this.category);
        List<String> r102 = this.autoMarkPkgs;
        if (r102 == null) goto L8;
        r100.putStringArrayList(KEY_AUTO_MARK_PKGS, (ArrayList) r102);
    L8:
        return r100;
    }

    public String toString() {
        return "command={" + this.command + "}, resultCode={" + this.resultCode + "}, reason={" + this.reason + "}, category={" + this.category + "}, commandArguments={" + this.commandArguments + com.alipay.sdk.m.u.i.f25855d;
    }

    public List<String> getAutoMarkPkgs() {
        return this.autoMarkPkgs;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public List<String> getCommandArguments() {
        return this.commandArguments;
    }

    public String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public static MiPushCommandMessage fromBundle(Bundle r100) {
        MiPushCommandMessage r101 = new MiPushCommandMessage();
        r101.command = r100.getString("command");
        r101.resultCode = r100.getLong("resultCode");
        r101.reason = r100.getString("reason");
        r101.commandArguments = r100.getStringArrayList(KEY_COMMAND_ARGUMENTS);
        r101.category = r100.getString("category");
        r101.autoMarkPkgs = r100.getStringArrayList(KEY_AUTO_MARK_PKGS);
        return r101;
    }

    public void setAutoMarkPkgs(List<String> r100) {
        this.autoMarkPkgs = r100;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setCommand(String r100) {
        this.command = r100;
    }

    public void setCommandArguments(List<String> r100) {
        this.commandArguments = r100;
    }

    public void setReason(String r100) {
        this.reason = r100;
    }

    public void setResultCode(long r100) {
        this.resultCode = r100;
    }
}
