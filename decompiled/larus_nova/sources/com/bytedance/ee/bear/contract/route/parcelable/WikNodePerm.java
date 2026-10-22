package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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
        public final WikNodePerm createFromParcel(Parcel r100) {
            return new WikNodePerm(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WikNodePerm[] newArray(int r100) {
            return new WikNodePerm[r100];
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
        WikNodePerm r100 = new WikNodePerm();
        r100.can_add_shortcut = false;
        r100.can_clone = false;
        r100.can_create = false;
        r100.can_delete = false;
        r100.can_destroy = false;
        r100.can_move = false;
        r100.can_rename = false;
        r100.is_locked = false;
        r100.show_move = false;
        return r100;
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
    public /* bridge */ /* synthetic */ Object m8325clone() throws CloneNotSupportedException {
        return clone();
    }

    public WikNodePerm(Parcel r100) {
        readFromParcel(r100);
    }

    public boolean getOriginCanClone(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_clone;
    L5:
        return this.can_clone;
    }

    public boolean getOriginCanCreate(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_create;
    L5:
        return this.can_create;
    }

    public boolean getOriginCanDownload(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_download;
    L5:
        return this.can_download;
    }

    public boolean getOriginCanExplorePin(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_explorer_pin;
    L5:
        return this.can_explorer_pin;
    }

    public boolean getOriginCanExploreStar(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_explorer_star;
    L5:
        return this.can_explorer_star;
    }

    public boolean getOriginCanShortcut(boolean r100) {
        if (r100 == false) goto L5;
        return this.origin_can_add_shortcut;
    L5:
        return this.can_add_shortcut;
    }

    public void readFromParcel(Parcel r100) {
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.can_add_shortcut = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.can_clone = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.can_create = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.can_delete = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.can_destroy = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.can_move = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.can_rename = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.can_star = r109;
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.is_locked = r110;
        if (r100.readByte() == 0) goto L41;
        boolean r111 = true;
    L42:
        this.show_move = r111;
        if (r100.readByte() == 0) goto L45;
        boolean r112 = true;
    L46:
        this.can_explorer_star = r112;
        if (r100.readByte() == 0) goto L49;
        boolean r113 = true;
    L50:
        this.can_explorer_pin = r113;
        if (r100.readByte() == 0) goto L53;
        boolean r114 = true;
    L54:
        this.can_download = r114;
        if (r100.readByte() == 0) goto L57;
        boolean r115 = true;
    L58:
        this.can_be_moved = r115;
        if (r100.readByte() == 0) goto L61;
        boolean r116 = true;
    L62:
        this.parent_root = r116;
        if (r100.readByte() == 0) goto L65;
        boolean r117 = true;
    L66:
        this.parent_can_move_from = r117;
        if (r100.readByte() == 0) goto L69;
        boolean r118 = true;
    L70:
        this.show_single_delete = r118;
        if (r100.readByte() == 0) goto L73;
        boolean r119 = true;
    L74:
        this.show_delete = r119;
        if (r100.readByte() == 0) goto L77;
        boolean r120 = true;
    L78:
        this.origin_can_create = r120;
        if (r100.readByte() == 0) goto L81;
        boolean r121 = true;
    L82:
        this.origin_can_move = r121;
        if (r100.readByte() == 0) goto L85;
        boolean r122 = true;
    L86:
        this.origin_can_delete = r122;
        if (r100.readByte() == 0) goto L89;
        boolean r123 = true;
    L90:
        this.origin_can_destroy = r123;
        if (r100.readByte() == 0) goto L93;
        boolean r124 = true;
    L94:
        this.origin_can_rename = r124;
        if (r100.readByte() == 0) goto L97;
        boolean r125 = true;
    L98:
        this.origin_can_add_shortcut = r125;
        if (r100.readByte() == 0) goto L101;
        boolean r126 = true;
    L102:
        this.origin_can_clone = r126;
        if (r100.readByte() == 0) goto L105;
        boolean r127 = true;
    L106:
        this.origin_can_star = r127;
        if (r100.readByte() == 0) goto L109;
        boolean r128 = true;
    L110:
        this.origin_show_move = r128;
        if (r100.readByte() == 0) goto L113;
        boolean r129 = true;
    L114:
        this.origin_can_explorer_star = r129;
        if (r100.readByte() == 0) goto L117;
        boolean r130 = true;
    L118:
        this.origin_can_explorer_pin = r130;
        if (r100.readByte() != 0) goto L122;
        r101 = false;
    L122:
        this.origin_can_download = r101;
        return;
    L117:
        r130 = false;
        goto L118
    L113:
        r129 = false;
        goto L114
    L109:
        r128 = false;
        goto L110
    L105:
        r127 = false;
        goto L106
    L101:
        r126 = false;
        goto L102
    L97:
        r125 = false;
        goto L98
    L93:
        r124 = false;
        goto L94
    L89:
        r123 = false;
        goto L90
    L85:
        r122 = false;
        goto L86
    L81:
        r121 = false;
        goto L82
    L77:
        r120 = false;
        goto L78
    L73:
        r119 = false;
        goto L74
    L69:
        r118 = false;
        goto L70
    L65:
        r117 = false;
        goto L66
    L61:
        r116 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.can_add_shortcut ? 1 : 0);
        r100.writeByte(this.can_clone ? 1 : 0);
        r100.writeByte(this.can_create ? 1 : 0);
        r100.writeByte(this.can_delete ? 1 : 0);
        r100.writeByte(this.can_destroy ? 1 : 0);
        r100.writeByte(this.can_move ? 1 : 0);
        r100.writeByte(this.can_rename ? 1 : 0);
        r100.writeByte(this.can_star ? 1 : 0);
        r100.writeByte(this.is_locked ? 1 : 0);
        r100.writeByte(this.show_move ? 1 : 0);
        r100.writeByte(this.can_explorer_star ? 1 : 0);
        r100.writeByte(this.can_explorer_pin ? 1 : 0);
        r100.writeByte(this.can_download ? 1 : 0);
        r100.writeByte(this.can_be_moved ? 1 : 0);
        r100.writeByte(this.parent_root ? 1 : 0);
        r100.writeByte(this.parent_can_move_from ? 1 : 0);
        r100.writeByte(this.show_single_delete ? 1 : 0);
        r100.writeByte(this.show_delete ? 1 : 0);
        r100.writeByte(this.origin_can_create ? 1 : 0);
        r100.writeByte(this.origin_can_move ? 1 : 0);
        r100.writeByte(this.origin_can_delete ? 1 : 0);
        r100.writeByte(this.origin_can_destroy ? 1 : 0);
        r100.writeByte(this.origin_can_rename ? 1 : 0);
        r100.writeByte(this.origin_can_add_shortcut ? 1 : 0);
        r100.writeByte(this.origin_can_clone ? 1 : 0);
        r100.writeByte(this.origin_can_star ? 1 : 0);
        r100.writeByte(this.origin_show_move ? 1 : 0);
        r100.writeByte(this.origin_can_explorer_star ? 1 : 0);
        r100.writeByte(this.origin_can_explorer_pin ? 1 : 0);
        r100.writeByte(this.origin_can_download ? 1 : 0);
    }
}
