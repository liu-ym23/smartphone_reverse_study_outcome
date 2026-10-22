package com.ss.android.lark.profile.utils;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes37.dex */
public interface IProfileLauncherV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f438837a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f438838a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IProfileLauncherV2> f438839b = null;

        public Companion() {
        }

        static {
            f438838a = new Companion();
            f438839b = LazyKt.lazy(IProfileLauncherV2$Companion$instance$2.INSTANCE);
        }

        public static IProfileLauncherV2 a() {
            return f438839b.getValue();
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IProfileLauncherV2 r100, Context r110, String r111, String r112, ContactSource r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r114 & 32) == 0) goto L9;
            String r102 = null;
        L10:
            r100.openUserProfileV2(r110, null, r101, null, null, r102, r113, null);
            return;
        L9:
            r102 = r112;
            goto L10
        L5:
            r101 = r111;
            goto L7
        }
    }

    static {
        f438837a = Companion.f438838a;
    }

    Fragment newUserProfileFragmentV2(Bundle r100);

    void openUserProfileV2(Context r100, Fragment r101, String r102, String r103, Chatter.Type r104, String r105, ContactSource r106, Integer r107);
}
