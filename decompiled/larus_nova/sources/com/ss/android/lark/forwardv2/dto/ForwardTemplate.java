package com.ss.android.lark.forwardv2.dto;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
import com.ss.android.lark.forwardv2.dto.template.ForwardLaunchParam;
import com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.IForwardProxyExecutor;
import com.ss.android.lark.forwardv2.dto.template.choosechat.PreSelectedPair;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardTemplate implements Parcelable {
    public static final Parcelable.Creator<ForwardTemplate> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BusinessRecentVisitIncludeConfig f424785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BusinessRecentVisitEnableConfig f424786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ForwardFeature f424787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForwardTargetFilter f424788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForwardViewDependency f424789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ForwardHitPoint f424790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f424791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ForwardLaunchParam f424792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.forwardv2.dto.template.b f424793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RemoteForwardExecutor f424794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IForwardProxyExecutor f424795k;

    public class a implements Parcelable.Creator<ForwardTemplate> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplate createFromParcel(Parcel r100) {
            return new ForwardTemplate(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplate[] newArray(int r100) {
            return new ForwardTemplate[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BusinessRecentVisitIncludeConfig f424797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BusinessRecentVisitEnableConfig f424798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ForwardFeature f424799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ForwardTargetFilter f424800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ForwardViewDependency f424801e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ForwardHitPoint f424802f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ForwardLaunchParam f424803g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Bundle f424804h;

        public b() {
        }

        public final ForwardTemplate a(com.ss.android.lark.forwardv2.dto.template.b r100) {
            ForwardTemplate r101 = new ForwardTemplate(r100);
            if (this.f424798b != null) goto L6;
            ArrayList<EntityItem> r102 = new ArrayList();
            BusinessRecentVisitEnableConfig r103 = new BusinessRecentVisitEnableConfig();
            r103.f424820c = r102;
            this.f424798b = r103;
        L6:
            if (this.f424797a != null) goto L9;
            ArrayList<EntityItem> r104 = new ArrayList();
            BusinessRecentVisitIncludeConfig r105 = new BusinessRecentVisitIncludeConfig();
            r105.f424822a = r104;
            this.f424797a = r105;
        L9:
            if (this.f424799c != null) goto L12;
            ArrayList<PreSelectedPair> r106 = new ArrayList();
            ForwardFeature r107 = new ForwardFeature();
            r107.f424825a = r106;
            r107.f424826b = true;
            r107.f424827c = true;
            r107.f424828d = true;
            r107.f424829e = 10;
            r107.f424830f = true;
            r107.f424834j = true;
            r107.f424831g = true;
            r107.f424832h = true;
            r107.f424833i = false;
            r107.f424835k = false;
            r107.f424837m = null;
            r107.f424838n = null;
            r107.f424836l = false;
            this.f424799c = r107;
        L12:
            if (this.f424800d != null) goto L15;
            ForwardTargetFilter r108 = new ForwardTargetFilter();
            r108.f424851a = false;
            r108.f424852b = false;
            r108.f424854d = true;
            r108.f424853c = false;
            r108.f424855e = false;
            r108.f424856f = false;
            r108.f424857g = true;
            r108.f424859i = false;
            r108.f424858h = true;
            r108.f424860j = false;
            this.f424800d = r108;
        L15:
            if (this.f424801e != null) goto L18;
            ForwardViewDependency r109 = new ForwardViewDependency();
            r109.f424870i = true;
            r109.f424865d = null;
            r109.f424866e = null;
            r109.f424862a = true;
            r109.f424863b = null;
            r109.f424864c = null;
            r109.f424867f = null;
            r109.f424868g = null;
            r109.f424869h = null;
            r109.f424871j = true;
            this.f424801e = r109;
        L18:
            if (this.f424802f != null) goto L21;
            ForwardHitPoint.a r110 = new ForwardHitPoint.a();
            ForwardHitPoint r111 = new ForwardHitPoint();
            r111.f424839a = null;
            r111.f424840b = "other";
            r111.f424841c = null;
            r111.f424842d = r110.f424845a;
            r111.f424843e = r110.f424846b;
            r111.f424844f = r110.f424847c;
            this.f424802f = r111;
        L21:
            if (this.f424803g != null) goto L23;
            ForwardLaunchParam r112 = new ForwardLaunchParam();
            r112.f424848a = 0;
            this.f424803g = r112;
        L23:
            r101.f424786b = this.f424798b;
            r101.f424785a = this.f424797a;
            r101.f424787c = this.f424799c;
            r101.f424788d = this.f424800d;
            r101.f424789e = this.f424801e;
            r101.f424790f = this.f424802f;
            r101.f424791g = this.f424804h;
            r101.f424792h = this.f424803g;
            return r101;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardTemplate(Parcel r100) {
        this.f424786b = (BusinessRecentVisitEnableConfig) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424785a = (BusinessRecentVisitIncludeConfig) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424787c = (ForwardFeature) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424788d = (ForwardTargetFilter) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424789e = (ForwardViewDependency) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424790f = (ForwardHitPoint) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424792h = (ForwardLaunchParam) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        if (r100.readInt() != 1) goto L5;
        this.f424794j = RemoteForwardExecutor.Stub.asInterface(r100.readStrongBinder());
    L6:
        this.f424795k = (IForwardProxyExecutor) r100.readParcelable(ForwardTemplate.class.getClassLoader());
        this.f424791g = r100.readBundle(ForwardTemplate.class.getClassLoader());
        return;
    L5:
        this.f424794j = null;
        goto L6
    }

    public ForwardTemplate(final com.ss.android.lark.forwardv2.dto.template.b r100) {
        this.f424793i = r100;
        this.f424794j = new AnonymousClass1(this, r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f424786b, r101);
        r100.writeParcelable(this.f424785a, r101);
        r100.writeParcelable(this.f424787c, r101);
        r100.writeParcelable(this.f424788d, r101);
        r100.writeParcelable(this.f424789e, r101);
        r100.writeParcelable(this.f424790f, r101);
        r100.writeParcelable(this.f424792h, r101);
        if (this.f424794j == null) goto L5;
        r100.writeInt(1);
        r100.writeStrongBinder(this.f424794j.asBinder());
    L6:
        r100.writeParcelable(this.f424795k, r101);
        r100.writeBundle(this.f424791g);
        return;
    L5:
        r100.writeInt(0);
        goto L6
    }
}
