package com.ss.android.lark.contact.export.model;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006%"}, d2 = {"Lcom/ss/android/lark/contact/export/model/PickType;", "Ljava/io/Serializable;", "<init>", "()V", "enableChatter", "", "getEnableChatter", "()Z", "setEnableChatter", "(Z)V", "enableExternalChatter", "getEnableExternalChatter", "setEnableExternalChatter", "enableGroupChat", "getEnableGroupChat", "setEnableGroupChat", "enableExternalGroup", "getEnableExternalGroup", "setEnableExternalGroup", "enableEmailContact", "getEnableEmailContact", "setEnableEmailContact", "enableEmailSharedAccount", "getEnableEmailSharedAccount", "setEnableEmailSharedAccount", "enableDepartment", "getEnableDepartment", "setEnableDepartment", "enablePublicGroup", "getEnablePublicGroup", "setEnablePublicGroup", "enableSecretGroup", "getEnableSecretGroup", "setEnableSecretGroup", "enableMeetingGroup", "getEnableMeetingGroup", "setEnableMeetingGroup", "contact-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickType implements Serializable {
    private boolean enableChatter;
    private boolean enableDepartment;
    private boolean enableEmailContact;
    private boolean enableEmailSharedAccount;
    private boolean enableExternalChatter;
    private boolean enableExternalGroup;
    private boolean enableGroupChat;
    private boolean enableMeetingGroup;
    private boolean enablePublicGroup;
    private boolean enableSecretGroup;

    public PickType() {
        this.enableChatter = true;
        this.enableExternalChatter = true;
        this.enableGroupChat = true;
        this.enablePublicGroup = true;
        this.enableSecretGroup = true;
        this.enableMeetingGroup = true;
    }

    public final boolean getEnableChatter() {
        return this.enableChatter;
    }

    public final boolean getEnableDepartment() {
        return this.enableDepartment;
    }

    public final boolean getEnableEmailContact() {
        return this.enableEmailContact;
    }

    public final boolean getEnableEmailSharedAccount() {
        return this.enableEmailSharedAccount;
    }

    public final boolean getEnableExternalChatter() {
        return this.enableExternalChatter;
    }

    public final boolean getEnableExternalGroup() {
        return this.enableExternalGroup;
    }

    public final boolean getEnableGroupChat() {
        return this.enableGroupChat;
    }

    public final boolean getEnableMeetingGroup() {
        return this.enableMeetingGroup;
    }

    public final boolean getEnablePublicGroup() {
        return this.enablePublicGroup;
    }

    public final boolean getEnableSecretGroup() {
        return this.enableSecretGroup;
    }

    public final void setEnableChatter(boolean r100) {
        this.enableChatter = r100;
    }

    public final void setEnableDepartment(boolean r100) {
        this.enableDepartment = r100;
    }

    public final void setEnableEmailContact(boolean r100) {
        this.enableEmailContact = r100;
    }

    public final void setEnableEmailSharedAccount(boolean r100) {
        this.enableEmailSharedAccount = r100;
    }

    public final void setEnableExternalChatter(boolean r100) {
        this.enableExternalChatter = r100;
    }

    public final void setEnableExternalGroup(boolean r100) {
        this.enableExternalGroup = r100;
    }

    public final void setEnableGroupChat(boolean r100) {
        this.enableGroupChat = r100;
    }

    public final void setEnableMeetingGroup(boolean r100) {
        this.enableMeetingGroup = r100;
    }

    public final void setEnablePublicGroup(boolean r100) {
        this.enablePublicGroup = r100;
    }

    public final void setEnableSecretGroup(boolean r100) {
        this.enableSecretGroup = r100;
    }
}
