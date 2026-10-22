package com.ss.android.lark.forwardv2.dto.template.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.picker.base.widget.utils.FG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class EntityItem implements Parcelable {
    public static final Parcelable.Creator<EntityItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserConfig f424880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GroupChatConfig f424881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BotConfig f424882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadConfig f424883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AIConfig f424884e;

    public class a implements Parcelable.Creator<EntityItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem createFromParcel(Parcel r100) {
            return new EntityItem(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem[] newArray(int r100) {
            return new EntityItem[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserConfig f424885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GroupChatConfig f424886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BotConfig f424887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadConfig f424888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AIConfig f424889e;

        public b() {
        }

        public final EntityItem a() {
            EntityItem r100 = new EntityItem();
            BotConfig r101 = this.f424887c;
            if (r101 == null) goto L5;
            r100.f424882c = r101;
            r100.f424881b = null;
            r100.f424880a = null;
            r100.f424883d = null;
            r100.f424884e = null;
        L5:
            GroupChatConfig r102 = this.f424886b;
            if (r102 == null) goto L8;
            r100.f424881b = r102;
            r100.f424880a = null;
            r100.f424883d = null;
            r100.f424882c = null;
            r100.f424884e = null;
        L8:
            ThreadConfig r103 = this.f424888d;
            if (r103 == null) goto L11;
            r100.f424883d = r103;
            r100.f424881b = null;
            r100.f424880a = null;
            r100.f424882c = null;
            r100.f424884e = null;
        L11:
            UserConfig r104 = this.f424885a;
            if (r104 == null) goto L15;
            r100.f424880a = r104;
            r100.f424881b = null;
            r100.f424883d = null;
            r100.f424882c = null;
            r100.f424884e = null;
        L15:
            if (this.f424889e == null) goto L19;
            int r105 = hib.a.f485390a;
            Intrinsics.checkNotNullParameter(FG.MY_AI, "key");
            if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable(FG.MY_AI) == false) goto L19;
            r100.f424884e = this.f424889e;
            r100.f424880a = null;
            r100.f424881b = null;
            r100.f424883d = null;
            r100.f424882c = null;
        L19:
            return r100;
        }

        public final void b(GroupChatConfig r100) {
            this.f424886b = r100;
            this.f424887c = null;
            this.f424885a = null;
            this.f424888d = null;
            this.f424889e = null;
        }

        public final void c(ThreadConfig r100) {
            this.f424888d = r100;
            this.f424887c = null;
            this.f424886b = null;
            this.f424885a = null;
            this.f424889e = null;
        }

        public final void d(UserConfig r100) {
            this.f424885a = r100;
            this.f424887c = null;
            this.f424886b = null;
            this.f424888d = null;
            this.f424889e = null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public EntityItem() {
    }

    public EntityItem(Parcel r100) {
        this.f424880a = (UserConfig) r100.readSerializable();
        this.f424881b = (GroupChatConfig) r100.readSerializable();
        this.f424883d = (ThreadConfig) r100.readSerializable();
        this.f424882c = (BotConfig) r100.readSerializable();
        this.f424884e = (AIConfig) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.f424880a);
        r100.writeSerializable(this.f424881b);
        r100.writeSerializable(this.f424883d);
        r100.writeSerializable(this.f424882c);
        r100.writeSerializable(this.f424884e);
    }
}
