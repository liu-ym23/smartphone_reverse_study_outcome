package com.larus;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import com.ss.android.lark.officesdk.l1;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/OfficeSDKHiltApplication;", "Landroid/app/Application;", "Lcom/ss/android/lark/officesdk/OfficeSDKHiltComponents;", "<init>", "()V", "officeSdkApp", "Lcom/ss/android/lark/officesdk/OfficeSDKAppDelegate;", "attachBaseContext", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "componentManager", "Ldagger/hilt/internal/GeneratedComponentManager;", "generatedComponent", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public class OfficeSDKHiltApplication extends Application implements GeneratedComponentManagerHolder {
    public final l1 a;

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager<?> componentManager() {
        return this.a.b;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.a.generatedComponent();
    }

    public OfficeSDKHiltApplication() {
        this.a = new l1(this);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super.attachBaseContext(r2);
        LarkContext.setApplication(this);
    }
}
