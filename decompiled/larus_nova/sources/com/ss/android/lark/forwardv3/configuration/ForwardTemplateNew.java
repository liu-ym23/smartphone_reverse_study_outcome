package com.ss.android.lark.forwardv3.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00108\u001a\u0002092\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "forwardTargetConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "getForwardTargetConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "setForwardTargetConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;)V", "forwardSelectConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "getForwardSelectConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "setForwardSelectConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;)V", "forwardCommonConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "getForwardCommonConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "setForwardCommonConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;)V", "forwardAdditionNoteConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "getForwardAdditionNoteConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "setForwardAdditionNoteConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;)V", "forwardConfirmDialogConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "getForwardConfirmDialogConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "setForwardConfirmDialogConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;)V", "forwardContent", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "getForwardContent", "()Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "setForwardContent", "(Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "source", "Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "getSource", "()Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "setSource", "(Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;)V", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTemplateNew implements Parcelable {
    public static final b CREATOR = null;
    private ForwardAdditionNoteConfig forwardAdditionNoteConfig;
    private ForwardCommonConfig forwardCommonConfig;
    private ForwardConfirmDialogConfig forwardConfirmDialogConfig;
    private IForwardContent forwardContent;
    private ForwardSelectConfig forwardSelectConfig;
    private ForwardTargetConfig forwardTargetConfig;
    private Forward$Source source;
    private int type;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ForwardTargetConfig f425206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ForwardSelectConfig f425207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ForwardCommonConfig f425208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ForwardAdditionNoteConfig f425209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ForwardConfirmDialogConfig f425210e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IForwardContent f425211f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f425212g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Forward$Source f425213h;

        public final ForwardTemplateNew a() {
            ForwardTemplateNew r100 = new ForwardTemplateNew();
            r100.setForwardTargetConfig(this.f425206a);
            r100.setForwardSelectConfig(this.f425207b);
            r100.setForwardCommonConfig(this.f425208c);
            r100.setForwardAdditionNoteConfig(this.f425209d);
            r100.setForwardConfirmDialogConfig(this.f425210e);
            r100.setForwardContent(this.f425211f);
            r100.setType(this.f425212g);
            r100.setSource(this.f425213h);
            return r100;
        }

        public a() {
            this.f425206a = new ForwardTargetConfig();
            this.f425207b = new ForwardSelectConfig();
            this.f425208c = new ForwardCommonConfig();
            this.f425209d = new ForwardAdditionNoteConfig();
            this.f425210e = new ForwardConfirmDialogConfig();
            this.f425213h = Forward$Source.UNKNOWN;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTemplateNew> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplateNew createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ForwardTemplateNew(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplateNew[] newArray(int r100) {
            return new ForwardTemplateNew[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Forward$Type
    public static /* synthetic */ void getType$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ForwardTemplateNew() {
        this.forwardTargetConfig = new ForwardTargetConfig();
        this.forwardSelectConfig = new ForwardSelectConfig();
        this.forwardCommonConfig = new ForwardCommonConfig();
        this.forwardAdditionNoteConfig = new ForwardAdditionNoteConfig();
        this.forwardConfirmDialogConfig = new ForwardConfirmDialogConfig();
        this.source = Forward$Source.UNKNOWN;
    }

    public final ForwardAdditionNoteConfig getForwardAdditionNoteConfig() {
        return this.forwardAdditionNoteConfig;
    }

    public final ForwardCommonConfig getForwardCommonConfig() {
        return this.forwardCommonConfig;
    }

    public final ForwardConfirmDialogConfig getForwardConfirmDialogConfig() {
        return this.forwardConfirmDialogConfig;
    }

    public final IForwardContent getForwardContent() {
        return this.forwardContent;
    }

    public final ForwardSelectConfig getForwardSelectConfig() {
        return this.forwardSelectConfig;
    }

    public final ForwardTargetConfig getForwardTargetConfig() {
        return this.forwardTargetConfig;
    }

    public final Forward$Source getSource() {
        return this.source;
    }

    public final int getType() {
        return this.type;
    }

    public ForwardTemplateNew(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        ForwardTargetConfig r101 = (ForwardTargetConfig) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r101 != null) goto L5;
        r101 = new ForwardTargetConfig();
    L5:
        this.forwardTargetConfig = r101;
        ForwardSelectConfig r102 = (ForwardSelectConfig) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r102 != null) goto L8;
        r102 = new ForwardSelectConfig();
    L8:
        this.forwardSelectConfig = r102;
        ForwardCommonConfig r103 = (ForwardCommonConfig) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r103 != null) goto L11;
        r103 = new ForwardCommonConfig();
    L11:
        this.forwardCommonConfig = r103;
        ForwardAdditionNoteConfig r104 = (ForwardAdditionNoteConfig) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r104 != null) goto L14;
        r104 = new ForwardAdditionNoteConfig();
    L14:
        this.forwardAdditionNoteConfig = r104;
        ForwardConfirmDialogConfig r105 = (ForwardConfirmDialogConfig) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r105 != null) goto L17;
        r105 = new ForwardConfirmDialogConfig();
    L17:
        this.forwardConfirmDialogConfig = r105;
        this.forwardContent = (IForwardContent) r100.readParcelable(ForwardTemplateNew.class.getClassLoader());
        this.type = r100.readInt();
        Forward$Source.a r106 = Forward$Source.Companion;
        int r107 = r100.readInt();
        r106.getClass();
        switch(r107) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            default: goto L19;
        };
    L19:
        Forward$Source r108 = Forward$Source.UNKNOWN;
    L23:
        this.source = r108;
        return;
    L20:
        r108 = Forward$Source.DOUBAO;
        goto L23
    L21:
        r108 = Forward$Source.KNOWLEDGE_AI;
        goto L23
    L22:
        r108 = Forward$Source.MY_AI;
        goto L23
    }

    public final void setForwardAdditionNoteConfig(ForwardAdditionNoteConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardAdditionNoteConfig = r100;
    }

    public final void setForwardCommonConfig(ForwardCommonConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardCommonConfig = r100;
    }

    public final void setForwardConfirmDialogConfig(ForwardConfirmDialogConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardConfirmDialogConfig = r100;
    }

    public final void setForwardContent(IForwardContent r100) {
        this.forwardContent = r100;
    }

    public final void setForwardSelectConfig(ForwardSelectConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardSelectConfig = r100;
    }

    public final void setForwardTargetConfig(ForwardTargetConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.forwardTargetConfig = r100;
    }

    public final void setSource(Forward$Source r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.source = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.forwardTargetConfig, r101);
        r100.writeParcelable(this.forwardSelectConfig, r101);
        r100.writeParcelable(this.forwardCommonConfig, r101);
        r100.writeParcelable(this.forwardAdditionNoteConfig, r101);
        r100.writeParcelable(this.forwardConfirmDialogConfig, r101);
        r100.writeParcelable(this.forwardContent, r101);
        r100.writeInt(this.type);
        r100.writeInt(this.source.getValue());
    }
}
