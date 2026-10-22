package com.ss.android.lark.forwardv3.configuration.targetconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.utils.FG;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/EntityItem;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "userConfig", "getUserConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "groupConfig", "getGroupConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/BotConfig;", "botConfig", "getBotConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/BotConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/ThreadConfig;", "threadConfig", "getThreadConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/ThreadConfig;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/AIConfig;", "aiConfig", "getAiConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/AIConfig;", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntityItem implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserConfig f425236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GroupConfig f425237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BotConfig f425238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadConfig f425239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AIConfig f425240e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserConfig f425241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GroupConfig f425242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BotConfig f425243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ThreadConfig f425244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AIConfig f425245e;

        public a() {
        }

        public final EntityItem c() {
            EntityItem r100 = new EntityItem();
            UserConfig r101 = this.f425241a;
            if (r101 == null) goto L5;
            r100.f425236a = r101;
        L5:
            GroupConfig r102 = this.f425242b;
            if (r102 == null) goto L8;
            r100.f425237b = r102;
        L8:
            BotConfig r103 = this.f425243c;
            if (r103 == null) goto L11;
            r100.f425238c = r103;
        L11:
            ThreadConfig r104 = this.f425244d;
            if (r104 == null) goto L15;
            r100.f425239d = r104;
        L15:
            if (this.f425245e == null) goto L19;
            int r105 = com.ss.android.lark.forwardv3.utils.b.f425568a;
            boolean r106 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(FG.MY_AI);
            Log.i("FGUtils", "FG key: lark.my_ai.main_switch, is " + r106);
            if (r106 == false) goto L19;
            r100.f425240e = this.f425245e;
        L19:
            return r100;
        }

        public final void a(AIConfig r100) {
            this.f425241a = null;
            this.f425242b = null;
            this.f425243c = null;
            this.f425244d = null;
            this.f425245e = r100;
        }

        public final void b(BotConfig r100) {
            this.f425241a = null;
            this.f425242b = null;
            this.f425243c = r100;
            this.f425244d = null;
            this.f425245e = null;
        }

        public final void d(GroupConfig r100) {
            this.f425241a = null;
            this.f425242b = r100;
            this.f425243c = null;
            this.f425244d = null;
            this.f425245e = null;
        }

        public final void e(ThreadConfig r100) {
            this.f425241a = null;
            this.f425242b = null;
            this.f425243c = null;
            this.f425244d = r100;
            this.f425245e = null;
        }

        public final void f(UserConfig r100) {
            this.f425241a = r100;
            this.f425242b = null;
            this.f425243c = null;
            this.f425244d = null;
            this.f425245e = null;
        }
    }

    public static final class b implements Parcelable.Creator<EntityItem> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EntityItem r101 = new EntityItem();
            r101.f425236a = (UserConfig) r100.readSerializable();
            r101.f425237b = (GroupConfig) r100.readSerializable();
            r101.f425238c = (BotConfig) r100.readSerializable();
            r101.f425239d = (ThreadConfig) r100.readSerializable();
            r101.f425240e = (AIConfig) r100.readSerializable();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final EntityItem[] newArray(int r100) {
            return new EntityItem[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public EntityItem() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f425236a);
        r100.writeSerializable(this.f425237b);
        r100.writeSerializable(this.f425238c);
        r100.writeSerializable(this.f425239d);
        r100.writeSerializable(this.f425240e);
    }
}
