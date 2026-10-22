package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikNodePerm implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<WikNodePerm> CREATOR = null;
    public boolean can_add_shortcut;
    public boolean can_be_moved;
    public boolean can_clone;
    public boolean can_create;
    public boolean can_delete;
    public boolean can_destroy;
    public boolean can_download;
    public boolean can_explorer_pin;
    public boolean can_explorer_star;
    public boolean can_move;
    public boolean can_rename;
    public boolean can_star;
    public boolean is_locked;
    public boolean origin_can_add_shortcut;
    public boolean origin_can_clone;
    public boolean origin_can_create;
    public boolean origin_can_delete;
    public boolean origin_can_destroy;
    public boolean origin_can_download;
    public boolean origin_can_explorer_pin;
    public boolean origin_can_explorer_star;
    public boolean origin_can_move;
    public boolean origin_can_rename;
    public boolean origin_can_star;
    public boolean origin_show_move;
    public boolean parent_can_move_from;
    public boolean parent_root;
    public boolean show_delete;
    public boolean show_move;
    public boolean show_single_delete;

    public class a implements Parcelable.Creator<WikNodePerm> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikNodePerm createFromParcel(Parcel r2) {
            return new WikNodePerm(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikNodePerm[] newArray(int r1) {
            return new WikNodePerm[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public static WikNodePerm defaulted() {
        WikNodePerm r0 = new WikNodePerm();
        r0.can_add_shortcut = false;
        r0.can_clone = false;
        r0.can_create = false;
        r0.can_delete = false;
        r0.can_destroy = false;
        r0.can_move = false;
        r0.can_rename = false;
        r0.is_locked = false;
        r0.show_move = false;
        return r0;
    }

    public String toString() {
        return "WikNodePerm{can_add_shortcut=" + this.can_add_shortcut + ", can_clone=" + this.can_clone + ", can_create=" + this.can_create + ", can_delete=" + this.can_delete + ", show_delete =" + this.show_delete + ", show_single_delete =" + this.show_single_delete + ", can_destroy=" + this.can_destroy + ", can_move=" + this.can_move + ", can_rename=" + this.can_rename + ", can_star=" + this.can_star + ", is_locked=" + this.is_locked + ", show_move=" + this.show_move + ", can_explorer_star=" + this.can_explorer_star + ", can_explorer_pin=" + this.can_explorer_pin + ", origin_can_create=" + this.origin_can_create + ", origin_can_explorer_star=" + this.origin_can_explorer_star + ", origin_can_explorer_pin=" + this.origin_can_explorer_pin + '}';
    }

    public WikNodePerm clone() {
        return (WikNodePerm) super.clone();
    L4:
        return null;
    }

    public WikNodePerm() {
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m120clone() throws CloneNotSupportedException {
        return clone();
    }

    public WikNodePerm(Parcel r1) {
        readFromParcel(r1);
    }

    public boolean getOriginCanClone(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_clone;
    L5:
        return this.can_clone;
    }

    public boolean getOriginCanCreate(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_create;
    L5:
        return this.can_create;
    }

    public boolean getOriginCanDownload(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_download;
    L5:
        return this.can_download;
    }

    public boolean getOriginCanExplorePin(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_explorer_pin;
    L5:
        return this.can_explorer_pin;
    }

    public boolean getOriginCanExploreStar(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_explorer_star;
    L5:
        return this.can_explorer_star;
    }

    public boolean getOriginCanShortcut(boolean r1) {
        if (r1 == false) goto L5;
        return this.origin_can_add_shortcut;
    L5:
        return this.can_add_shortcut;
    }

    public void readFromParcel(Parcel r4) {
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.can_add_shortcut = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.can_clone = r2;
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.can_create = r3;
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.can_delete = r5;
        if (r4.readByte() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.can_destroy = r6;
        if (r4.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.can_move = r7;
        if (r4.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.can_rename = r8;
        if (r4.readByte() == 0) goto L33;
        boolean r9 = true;
    L34:
        this.can_star = r9;
        if (r4.readByte() == 0) goto L37;
        boolean r10 = true;
    L38:
        this.is_locked = r10;
        if (r4.readByte() == 0) goto L41;
        boolean r11 = true;
    L42:
        this.show_move = r11;
        if (r4.readByte() == 0) goto L45;
        boolean r12 = true;
    L46:
        this.can_explorer_star = r12;
        if (r4.readByte() == 0) goto L49;
        boolean r13 = true;
    L50:
        this.can_explorer_pin = r13;
        if (r4.readByte() == 0) goto L53;
        boolean r14 = true;
    L54:
        this.can_download = r14;
        if (r4.readByte() == 0) goto L57;
        boolean r16 = true;
    L58:
        this.can_be_moved = r16;
        if (r4.readByte() == 0) goto L61;
        boolean r17 = true;
    L62:
        this.parent_root = r17;
        if (r4.readByte() == 0) goto L65;
        boolean r18 = true;
    L66:
        this.parent_can_move_from = r18;
        if (r4.readByte() == 0) goto L69;
        boolean r19 = true;
    L70:
        this.show_single_delete = r19;
        if (r4.readByte() == 0) goto L73;
        boolean r20 = true;
    L74:
        this.show_delete = r20;
        if (r4.readByte() == 0) goto L77;
        boolean r21 = true;
    L78:
        this.origin_can_create = r21;
        if (r4.readByte() == 0) goto L81;
        boolean r22 = true;
    L82:
        this.origin_can_move = r22;
        if (r4.readByte() == 0) goto L85;
        boolean r23 = true;
    L86:
        this.origin_can_delete = r23;
        if (r4.readByte() == 0) goto L89;
        boolean r24 = true;
    L90:
        this.origin_can_destroy = r24;
        if (r4.readByte() == 0) goto L93;
        boolean r26 = true;
    L94:
        this.origin_can_rename = r26;
        if (r4.readByte() == 0) goto L97;
        boolean r27 = true;
    L98:
        this.origin_can_add_shortcut = r27;
        if (r4.readByte() == 0) goto L101;
        boolean r28 = true;
    L102:
        this.origin_can_clone = r28;
        if (r4.readByte() == 0) goto L105;
        boolean r29 = true;
    L106:
        this.origin_can_star = r29;
        if (r4.readByte() == 0) goto L109;
        boolean r30 = true;
    L110:
        this.origin_show_move = r30;
        if (r4.readByte() == 0) goto L113;
        boolean r31 = true;
    L114:
        this.origin_can_explorer_star = r31;
        if (r4.readByte() == 0) goto L117;
        boolean r32 = true;
    L118:
        this.origin_can_explorer_pin = r32;
        if (r4.readByte() != 0) goto L122;
        r1 = false;
    L122:
        this.origin_can_download = r1;
        return;
    L117:
        r32 = false;
        goto L118
    L113:
        r31 = false;
        goto L114
    L109:
        r30 = false;
        goto L110
    L105:
        r29 = false;
        goto L106
    L101:
        r28 = false;
        goto L102
    L97:
        r27 = false;
        goto L98
    L93:
        r26 = false;
        goto L94
    L89:
        r24 = false;
        goto L90
    L85:
        r23 = false;
        goto L86
    L81:
        r22 = false;
        goto L82
    L77:
        r21 = false;
        goto L78
    L73:
        r20 = false;
        goto L74
    L69:
        r19 = false;
        goto L70
    L65:
        r18 = false;
        goto L66
    L61:
        r17 = false;
        goto L62
    L57:
        r16 = false;
        goto L58
    L53:
        r14 = false;
        goto L54
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L37:
        r10 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.can_add_shortcut ? 1 : 0);
        r1.writeByte(this.can_clone ? 1 : 0);
        r1.writeByte(this.can_create ? 1 : 0);
        r1.writeByte(this.can_delete ? 1 : 0);
        r1.writeByte(this.can_destroy ? 1 : 0);
        r1.writeByte(this.can_move ? 1 : 0);
        r1.writeByte(this.can_rename ? 1 : 0);
        r1.writeByte(this.can_star ? 1 : 0);
        r1.writeByte(this.is_locked ? 1 : 0);
        r1.writeByte(this.show_move ? 1 : 0);
        r1.writeByte(this.can_explorer_star ? 1 : 0);
        r1.writeByte(this.can_explorer_pin ? 1 : 0);
        r1.writeByte(this.can_download ? 1 : 0);
        r1.writeByte(this.can_be_moved ? 1 : 0);
        r1.writeByte(this.parent_root ? 1 : 0);
        r1.writeByte(this.parent_can_move_from ? 1 : 0);
        r1.writeByte(this.show_single_delete ? 1 : 0);
        r1.writeByte(this.show_delete ? 1 : 0);
        r1.writeByte(this.origin_can_create ? 1 : 0);
        r1.writeByte(this.origin_can_move ? 1 : 0);
        r1.writeByte(this.origin_can_delete ? 1 : 0);
        r1.writeByte(this.origin_can_destroy ? 1 : 0);
        r1.writeByte(this.origin_can_rename ? 1 : 0);
        r1.writeByte(this.origin_can_add_shortcut ? 1 : 0);
        r1.writeByte(this.origin_can_clone ? 1 : 0);
        r1.writeByte(this.origin_can_star ? 1 : 0);
        r1.writeByte(this.origin_show_move ? 1 : 0);
        r1.writeByte(this.origin_can_explorer_star ? 1 : 0);
        r1.writeByte(this.origin_can_explorer_pin ? 1 : 0);
        r1.writeByte(this.origin_can_download ? 1 : 0);
    }
}
