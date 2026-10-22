package com.larus.platform.api.creation;

import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J!\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003H&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "", "enableBachDetect", "", "detectAvatarUri", "", "uri", "Landroid/net/Uri;", "searchBachDetectResult", "remove", "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "cancelBachDetectTask", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBachDetectCenterAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f364932a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J!\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001J \u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/api/creation/IBachDetectCenterAbility$Companion;", "Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "<init>", "()V", "cancelBachDetectTask", "", "uri", "Landroid/net/Uri;", "detectAvatarUri", "enableBachDetect", "", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "searchBachDetectResult", "remove", "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBachDetectCenterAbility {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f364933c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBachDetectCenterAbility f364934b;

        static {
            f364933c = new Companion();
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void a(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f364934b.a(r100);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final boolean b() {
            return this.f364934b.b();
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final Boolean c(Uri r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return this.f364934b.c(r100, r101);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void d(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f364934b.d(r100);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void e(Uri r100, Uri r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "oldUri");
            Intrinsics.checkNotNullParameter(r101, "newUri");
            this.f364934b.e(r100, r101, r102);
        }

        private Companion() {
            IBachDetectCenterAbility r100 = (IBachDetectCenterAbility) ServiceManager.get().getService(IBachDetectCenterAbility.class);
            if (r100 != null) goto L5;
            r100 = new BachDetectCenterAbilityNoop();
        L5:
            this.f364934b = r100;
        }
    }

    static {
        f364932a = Companion.f364933c;
    }

    void a(Uri r100);

    boolean b();

    Boolean c(Uri r100, boolean r101);

    void d(Uri r100);

    void e(Uri r100, Uri r101, boolean r102);
}
