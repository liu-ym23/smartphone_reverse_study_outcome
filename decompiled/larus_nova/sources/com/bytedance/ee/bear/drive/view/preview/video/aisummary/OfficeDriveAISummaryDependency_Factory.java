package com.bytedance.ee.bear.drive.view.preview.video.aisummary;

import dagger.internal.Factory;
import fa5.b;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDriveAISummaryDependency_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeDriveAISummaryDependency_Factory f225532a = null;

        static {
            f225532a = new OfficeDriveAISummaryDependency_Factory();
        }
    }

    public OfficeDriveAISummaryDependency_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static OfficeDriveAISummaryDependency_Factory create() {
        return a.f225532a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
