package com.larus.drive.sdk.impl.gallery;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.chat.gallery.api.PreviewSendFailureReason;
import com.larus.chat.gallery.api.PreviewSourceAction;
import com.larus.chat.gallery.api.r;
import com.larus.chat.gallery.api.v;
import com.larus.chat.gallery.api.w;
import com.larus.chat.gallery.api.y;
import com.larus.chat.gallery.api.z;
import com.larus.chat.gallery.impl.preview.provider.x0;
import com.larus.chat.gallery.impl.preview.provider.y0;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.drive.sdk.impl.gallery.datasource.DriveGalleryDataSource;
import com.larus.drive.sdk.impl.gallery.provider.DriveGalleryInputProvider;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.utils.MorePanelHelper;
import com.larus.drive.sdk.impl.view.chat.DriveInputFragment;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.nova.R;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import t19.s;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveGalleryHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveGalleryHelper f341764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f341765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f341766c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f341767d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e89.c f341768e = null;

    public static final class DrivePreviewMediaSession extends com.larus.chat.gallery.api.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z79.b f341769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<com.larus.chat.gallery.api.o> f341770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, z79.c> f341771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, DriveFileItem> f341772f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final DrivePreviewSourceInput f341773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<AttachmentSnapshot> f341774h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, AttachmentSnapshot> f341775i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Set<String> f341776j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Set<Function1<List<AttachmentSnapshot>, Unit>> f341777k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f341778l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f341779m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f341780n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f341781o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final com.larus.chat.gallery.api.l f341782p;

        public final class DrivePreviewSourceInput implements z {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public z79.c f341783a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Function0<Unit> f341784b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Function1<? super String, Unit> f341785c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Function2<? super String, ? super Boolean, Unit> f341786d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Function0<Unit> f341787e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Function0<Unit> f341788f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f341789g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final Lazy f341790h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ DrivePreviewMediaSession f341791i;

            public final DriveInputFragment h() {
                return (DriveInputFragment) this.f341790h.getValue();
            }

            @Override // com.larus.chat.gallery.api.z
            public final DriveInputFragment a() {
                return h();
            }

            public DrivePreviewSourceInput(DrivePreviewMediaSession r100) {
                this.f341791i = r100;
                this.f341783a = r100.f341771e.get(r100.f341769c.f570685b.f341565b);
                this.f341790h = LazyKt.lazy(new k(this));
            }

            @Override // com.larus.chat.gallery.api.z
            public final void b(Function0<Unit> r100) {
                this.f341788f = r100;
            }

            @Override // com.larus.chat.gallery.api.z
            public final void c(Function0<Unit> r100) {
                this.f341787e = r100;
            }

            @Override // com.larus.chat.gallery.api.z
            public final void d(String r100) {
                Intrinsics.checkNotNullParameter(r100, "itemKey");
                DrivePreviewMediaSession r101 = this.f341791i;
                r101.f341778l = r100;
                z79.c r102 = r101.f341771e.get(r100);
                this.f341783a = r102;
                DriveGalleryHelper r103 = DriveGalleryHelper.f341764a;
                if (r102 == null) goto L5;
                DriveFileItem r104 = r102.f570691a;
            L6:
                final boolean r105 = DriveGalleryHelper.c(r104);
                View r106 = h().getView();
                if (r106 == null) goto L9;
                r106.post(new l(this, r105));
            L9:
                this.f341791i.x();
                return;
            L5:
                r104 = null;
                goto L6
            }

            @Override // com.larus.chat.gallery.api.z
            public final void e(x0 r100) {
                this.f341784b = r100;
            }

            @Override // com.larus.chat.gallery.api.z
            public final void f(y0 r100) {
                this.f341786d = r100;
            }

            @Override // com.larus.chat.gallery.api.z
            public final void g(Function1<? super String, Unit> r100) {
                this.f341785c = r100;
            }

            public final void i(boolean r100) {
                if (r100 == false) goto L7;
                Function0<Unit> r101 = this.f341784b;
                if (r101 == null) goto L15;
                r101.invoke();
                return;
            L15:
                return;
            L7:
                DriveGalleryHelper r102 = DriveGalleryHelper.f341764a;
                z79.c r103 = this.f341783a;
                if (r103 == null) goto L10;
                DriveFileItem r104 = r103.f570691a;
            L11:
                final boolean r105 = DriveGalleryHelper.c(r104);
                View r106 = h().getView();
                if (r106 == null) goto L16;
                r106.post(new m(this, r105));
                return;
            L16:
                return;
            L10:
                r104 = null;
                goto L11
            }
        }

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f341795a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f341796b = null;

            static {
                int[] r100 = new int[PreviewSourceAction.values().length];
                r100[PreviewSourceAction.SHARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[PreviewSourceAction.DOWNLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L33:
                r100[PreviewSourceAction.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L25:
                r100[PreviewSourceAction.RENAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[PreviewSourceAction.MOVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
            L9:
                f341795a = r100;
                int[] r101 = new int[DriveFileType.values().length];
                r101[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
            L21:
                r101[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
            L12:
                f341796b = r101;
            }
        }

        @Override // com.larus.chat.gallery.api.n
        public final boolean g() {
            return true;
        }

        @Override // com.larus.chat.gallery.api.q
        public final void u() {
            this.f341781o = false;
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.u
        public final List<AttachmentSnapshot> Qa() {
            List r100 = CollectionsKt.createListBuilder();
            DriveFileItem r101 = this.f341772f.get(this.f341778l);
            AttachmentSnapshot r102 = null;
            if (r101 != null) goto L6;
        L33:
            if (r102 == null) goto L35;
            r100.add(r102);
        L35:
            List<AttachmentSnapshot> r103 = this.f341774h;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r103.iterator();
        L37:
            if (r105.hasNext() == false) goto L41;
            Object r106 = r105.next();
            if (this.f341776j.contains(((AttachmentSnapshot) r106).getStableId()) == true) goto L37;
            r104.add(r106);
            goto L37
        L41:
            r100.addAll(r104);
            List r107 = CollectionsKt.build(r100);
            HashSet r108 = new HashSet();
            ArrayList r109 = new ArrayList();
            Iterator r110 = r107.iterator();
        L43:
            if (r110.hasNext() == false) goto L47;
            Object r111 = r110.next();
            if (r108.add(((AttachmentSnapshot) r111).getStableId()) == false) goto L43;
            r109.add(r111);
            goto L43
        L47:
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator r113 = r109.iterator();
            int r210 = 0;
        L49:
            if (r113.hasNext() == false) goto L54;
            Object r114 = r113.next();
            int r211 = r210 + 1;
            if (r210 >= 0) goto L53;
            CollectionsKt.throwIndexOverflow();
        L53:
            r112.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r114, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r210, null, null, 114687, null));
            r210 = r211;
            goto L49
        L54:
            return r112;
        L6:
            if (this.f341776j.contains(r101.f341565b) == true) goto L33;
            AttachmentSnapshot r115 = (AttachmentSnapshot) ((LinkedHashMap) this.f341775i).get(r101.f341565b);
            if (r115 == null) goto L11;
            r102 = r115;
            goto L33
        L11:
            String r116 = r101.f341568e;
            if (StringsKt.isBlank(r116) == false) goto L14;
            r116 = r101.f341565b;
        L14:
            String r117 = r116;
            if (StringsKt.isBlank(r101.f341568e) == false) goto L17;
            ResourceRefKind r118 = ResourceRefKind.CLOUD_TOKEN;
        L18:
            ResourceRef r212 = new ResourceRef(r117, r118, r101.f341565b, 0, 0, 24, null);
            int r119 = a.f341796b[r101.f341573j.ordinal()];
            boolean r120 = true;
            if (r119 != 1) goto L21;
            AttachmentMediaType r121 = AttachmentMediaType.IMAGE;
        L25:
            String r122 = r101.f341568e;
            String r123 = r101.f341565b;
            String r124 = r101.f341564a;
            int r125 = r101.f341567d;
            DriveUplinkInfo r126 = new DriveUplinkInfo(r122, r123, r124, r125, r125, "input_ai_space");
            String r127 = r101.f341565b;
            AttachmentSource r128 = AttachmentSource.CLOUD_DRIVE;
            if (r121 != AttachmentMediaType.FILE) goto L29;
            r120 = false;
        L29:
            if (r120 == false) goto L31;
            ResourceRef r129 = r212;
        L32:
            r102 = new AttachmentSnapshot(r127, r128, r121, r212, r129, r212, r101.f341564a, null, Long.valueOf(r101.e()), r101.f341565b, null, 0, AttachmentUploadState.UPLOADED, null, 0, AttachmentSendableState.SENDABLE, MapsKt.mapOf(TuplesKt.to("drive_uplink_info", r126.toString())), 27776, null);
            goto L33
        L31:
            r129 = null;
            goto L32
        L21:
            if (r119 == 2) goto L23;
            r121 = AttachmentMediaType.FILE;
            goto L25
        L23:
            r121 = AttachmentMediaType.VIDEO;
            goto L25
        L17:
            r118 = ResourceRefKind.REMOTE_URL;
            goto L18
        }

        public final void x() {
            List<AttachmentSnapshot> r100 = Qa();
            Iterator r101 = CollectionsKt.toList(this.f341777k).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((Function1) r101.next()).invoke(r100);
            goto L4
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.n
        public final String a() {
            return this.f341779m;
        }

        @Override // com.larus.chat.gallery.api.q
        public final List<com.larus.chat.gallery.api.o> d() {
            return this.f341770d;
        }

        @Override // com.larus.chat.gallery.api.q
        public final com.larus.chat.gallery.api.l getCapability() {
            return this.f341782p;
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.q
        public final z p() {
            return this.f341773g;
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.u
        public final boolean Oa(String r100) {
            Intrinsics.checkNotNullParameter(r100, "itemKey");
            List<AttachmentSnapshot> r101 = Qa();
            if (r101.isEmpty() == true) goto L15;
            Iterator<T> r102 = r101.iterator();
        L7:
            if (r102.hasNext() == false) goto L16;
            if (Intrinsics.areEqual(((AttachmentSnapshot) r102.next()).getStableId(), r100) == false) goto L7;
            return true;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // com.larus.chat.gallery.api.q
        public final void b(Function1<? super List<AttachmentSnapshot>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f341777k.remove(r100);
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.q
        public final void c(Dialog r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            DriveFileItem r101 = this.f341769c.f570685b;
            DriveGalleryHelper.f341768e.o(r101.f341565b, r101.f341567d, r100);
        }

        @Override // com.larus.chat.gallery.api.q
        public final void f(Function1<? super List<AttachmentSnapshot>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f341777k.add(r100);
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.q
        public final String getTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "itemKey");
            DriveFileItem r101 = this.f341772f.get(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.f341564a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.drive.sdk.impl.gallery.o] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.drive.sdk.impl.gallery.j, java.lang.Object] */
        @Override // com.larus.chat.gallery.api.x
        public final v m(w r110) {
            Intrinsics.checkNotNullParameter(r110, "snapshot");
            if (this.f341780n == false) goto L6;
            int r111 = v.f324180d;
            return v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L6:
            List<AttachmentSnapshot> r100 = Qa();
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
            Iterator r102 = ((ArrayList) r100).iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r101.add(((AttachmentSnapshot) r102.next()).getStableId());
            goto L8
        L10:
            List<AttachmentSnapshot> r103 = r110.f324184a;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L12:
            if (r105.hasNext() == false) goto L15;
            r104.add(((AttachmentSnapshot) r105.next()).getStableId());
            goto L12
        L15:
            if (Intrinsics.areEqual(r101, r104) == true) goto L18;
            int r112 = v.f324180d;
            return v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L18:
            this.f341780n = true;
            final DrivePreviewSourceInput r106 = this.f341773g;
            DriveFileItem r107 = this.f341772f.get(this.f341778l);
            ?? r108 = new j(this);
            r106.getClass();
            Intrinsics.checkNotNullParameter(r110, "snapshot");
            Intrinsics.checkNotNullParameter(r108, "onResult");
            boolean r109 = r106.f341789g;
            r106.f341789g = false;
            View r113 = r106.h().getView();
            if (r113 == null) goto L21;
            r113.post(new n(r106));
        L21:
            r79.a r114 = (r79.a) s1a.a.g(r106.h()).getAbility(r79.a.class);
            if (r114 == 0) goto L26;
            String r115 = r110.f324185b;
            List<AttachmentSnapshot> r116 = r110.f324184a;
            final DrivePreviewMediaSession r117 = r106.f341791i;
            if (r114.OG(r115, r116, r107, r109, r108, new o(r117)) != true) goto L26;
            boolean r118 = true;
        L27:
            if (r118 == true) goto L33;
            this.f341780n = false;
            this.f341773g.i(false);
            int r119 = v.f324180d;
            return v.a.a(PreviewSendFailureReason.HOST_UNAVAILABLE);
        L33:
            return new v(true, null, 2);
        L26:
            r118 = false;
            goto L27
        }

        @Override // com.larus.chat.gallery.api.s
        public final boolean q(r r310) {
            Intrinsics.checkNotNullParameter(r310, "mutation");
            int r100 = 0;
            if ((r310 instanceof r.b) == false) goto L22;
            r.b r101 = (r.b) r310;
            String r102 = r101.f324178a;
            Iterator r103 = ((ArrayList) this.f341774h).iterator();
            int r104 = 0;
        L6:
            if (r103.hasNext() == false) goto L11;
            if (Intrinsics.areEqual(((AttachmentSnapshot) r103.next()).getStableId(), r102) == true) goto L13;
            r104 = r104 + 1;
        L13:
            if (this.f341772f.containsKey(r102) == true) goto L16;
            if (r104 >= 0) goto L16;
            return false;
        L16:
            AttachmentSnapshot r105 = r101.f324179b;
            int r106 = r104;
            AttachmentSnapshot r107 = AttachmentSnapshot.copy$default(r105, r102, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, 131070, null);
            if (this.f341772f.containsKey(r102) == false) goto L19;
            this.f341775i.put(r102, r107);
        L20:
            this.f341776j.remove(r102);
            x();
        L68:
            return true;
        L19:
            ListProtector.set(this.f341774h, r106, r107);
            goto L20
        L11:
            r104 = -1;
            goto L13
        L22:
            if ((r310 instanceof r.a) == false) goto L71;
            List<AttachmentSnapshot> r108 = ((r.a) r310).f324177a;
            List<AttachmentSnapshot> r109 = r108;
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator<T> r111 = r109.iterator();
        L25:
            if (r111.hasNext() == false) goto L27;
            r110.add(((AttachmentSnapshot) r111.next()).getStableId());
            goto L25
        L27:
            Set<String> r112 = this.f341772f.keySet();
            List<AttachmentSnapshot> r113 = this.f341774h;
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator r115 = ((ArrayList) r113).iterator();
        L29:
            if (r115.hasNext() == false) goto L31;
            r114.add(((AttachmentSnapshot) r115.next()).getStableId());
            goto L29
        L31:
            Set r116 = SetsKt.plus(r112, r114);
            if (r108.isEmpty() == false) goto L34;
        L69:
            return false;
        L34:
            if (r110.isEmpty() == true) goto L42;
            Iterator r117 = r110.iterator();
        L38:
            if (r117.hasNext() == false) goto L42;
            if (StringsKt.isBlank((String) r117.next()) == false) goto L38;
            boolean r118 = true;
        L43:
            if (r118 == true) goto L69;
            if (r110.size() != CollectionsKt.distinct(r110).size()) goto L69;
            if (r110.isEmpty() == true) goto L55;
            Iterator r119 = r110.iterator();
        L51:
            if (r119.hasNext() == false) goto L55;
            if (r116.contains((String) r119.next()) == false) goto L51;
            boolean r120 = true;
        L56:
            if (r120 == true) goto L69;
            int r121 = ((ArrayList) Qa()).size() + r108.size();
            ImFileUtil.f314899a.getClass();
            if (r121 > ImFileUtil.m()) goto L69;
            List<AttachmentSnapshot> r122 = r108;
            ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
            Iterator<T> r124 = r122.iterator();
        L62:
            if (r124.hasNext() == false) goto L67;
            Object r125 = r124.next();
            int r126 = r100 + 1;
            if (r100 >= 0) goto L66;
            CollectionsKt.throwIndexOverflow();
        L66:
            r123.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r125, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, (((ArrayList) this.f341774h).size() + r100) + 1, null, null, 114687, null));
            r100 = r126;
            goto L62
        L67:
            ((ArrayList) this.f341774h).addAll(r123);
            this.f341776j.removeAll(CollectionsKt.toSet(r110));
            x();
        L55:
            r120 = false;
        L42:
            r118 = false;
            goto L43
        L71:
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.larus.chat.gallery.api.n
        public final boolean s(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f341779m = r100;
            return true;
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.t
        public final boolean t(String r100) {
            Intrinsics.checkNotNullParameter(r100, "itemKey");
            if (Oa(r100) == true) goto L6;
            return false;
        L6:
            this.f341776j.add(r100);
            x();
            return true;
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.q
        public final boolean l(PreviewSourceAction r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "itemKey");
            DriveFileItem r102 = this.f341772f.get(r101);
            if (r102 != null) goto L5;
            return false;
        L5:
            int r103 = a.f341795a[r100.ordinal()];
            if (r103 != 1) goto L8;
        L34:
            return true;
        L8:
            if (r103 == 2) goto L34;
            if (r103 == 3) goto L34;
            if (r103 == 4) goto L23;
            if (r103 != 5) goto L21;
            if (r102.g() == true) goto L34;
            if (this.f341769c.f570688e == PreviewFromPage.MINE) goto L34;
            return false;
        L21:
            throw new NoWhenBranchMatchedException();
        L23:
            if (r102.g() == false) goto L37;
            DriveFileType r104 = r102.f341573j;
            if (r104 != DriveFileType.AI_DOC) goto L27;
        L32:
            boolean r105 = true;
        L33:
            if (r105 == false) goto L34;
            return false;
        L27:
            if (r104 == DriveFileType.AI_SLIDES) goto L32;
            if (r104 == DriveFileType.AI_SHEET) goto L32;
            r105 = false;
            goto L33
        L37:
            return false;
        }

        public DrivePreviewMediaSession(z79.b r110, List<z79.c> r111, List<com.larus.chat.gallery.api.o> r112) {
            Intrinsics.checkNotNullParameter(r110, "galleryContext");
            Intrinsics.checkNotNullParameter(r111, "galleryData");
            Intrinsics.checkNotNullParameter(r112, "items");
            this.f341769c = r110;
            this.f341770d = r112;
            List<z79.c> r113 = r111;
            ArrayList r114 = new ArrayList();
            Iterator<T> r115 = r113.iterator();
        L3:
            Pair r100 = null;
            if (r115.hasNext() == false) goto L12;
            z79.c r101 = (z79.c) r115.next();
            DriveFileItem r102 = r101.f570691a;
            if (r102 == null) goto L10;
            String r103 = r102.f341565b;
            if (r103 == null) goto L10;
            r100 = TuplesKt.to(r103, r101);
        L10:
            if (r100 == null) goto L3;
            r114.add(r100);
            goto L3
        L12:
            this.f341771e = MapsKt.toMutableMap(MapsKt.toMap(r114));
            ArrayList r116 = new ArrayList();
            Iterator<T> r117 = r113.iterator();
        L14:
            if (r117.hasNext() == false) goto L21;
            DriveFileItem r118 = ((z79.c) r117.next()).f570691a;
            if (r118 == null) goto L18;
            Pair r119 = TuplesKt.to(r118.f341565b, r118);
        L19:
            if (r119 == null) goto L14;
            r116.add(r119);
            goto L14
        L18:
            r119 = null;
            goto L19
        L21:
            this.f341772f = MapsKt.toMutableMap(MapsKt.toMap(r116));
            this.f341773g = new DrivePreviewSourceInput(this);
            this.f341774h = new ArrayList();
            this.f341775i = new LinkedHashMap();
            this.f341776j = new LinkedHashSet();
            this.f341777k = new LinkedHashSet();
            this.f341778l = this.f341769c.f570685b.f341565b;
            this.f341779m = "";
            this.f341781o = true;
            this.f341782p = new com.larus.chat.gallery.api.l(true, false, true, true, true, true, true, 2);
        }

        @Override // com.larus.chat.gallery.api.a, com.larus.chat.gallery.api.q
        public final boolean v(PreviewSourceAction r510, String r511, k0 r512) {
            Intrinsics.checkNotNullParameter(r510, "action");
            Intrinsics.checkNotNullParameter(r511, "itemKey");
            Intrinsics.checkNotNullParameter(r512, "onResult");
            DriveFileItem r100 = this.f341772f.get(r511);
            if (r100 != null) goto L6;
            return false;
        L6:
            if (l(r510, r511) == true) goto L9;
            return false;
        L9:
            if (r510 != PreviewSourceAction.SHARE) goto L12;
            BuildersKt.launch$default(this.f341769c.f570686c, null, null, new DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1(r100, this, r512, null), 3, null);
            return true;
        L12:
            int r101 = a.f341795a[r510.ordinal()];
            if (r101 != 1) goto L15;
            int r110 = 10002;
        L29:
            Lazy r102 = MorePanelHelper.f341994a;
            MorePanelHelper.e(new l0(r110, 0, "", null, null, null, null, null, null, false, false, null, 0, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127), r100, this.f341769c.getContext(), this.f341769c.f570686c, new p(this, r512), 32);
            if (r510 != PreviewSourceAction.DOWNLOAD) goto L32;
        L33:
            r512.invoke(y.a.f324192a);
        L34:
            return true;
        L32:
            if (r510 != PreviewSourceAction.MOVE) goto L34;
        L15:
            if (r101 != 2) goto L17;
            r110 = 10003;
            goto L29
        L17:
            if (r101 != 3) goto L19;
            r110 = 10006;
            goto L29
        L19:
            if (r101 != 4) goto L21;
            r110 = 10004;
            goto L29
        L21:
            if (r101 != 5) goto L24;
            r110 = 10005;
            goto L29
        L24:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z0 f341797a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f341797a, ((a) r100).f341797a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            z0 r100 = this.f341797a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "EditConfig(customActionBarItem=" + this.f341797a + ')';
        }

        public a(z0 r100) {
            this.f341797a = r100;
        }
    }

    public DriveGalleryHelper() {
    }

    static {
        f341764a = new DriveGalleryHelper();
        f341765b = LazyKt.lazy(new com.larus.drive.sdk.impl.gallery.a());
        f341766c = LazyKt.lazy(new b());
        f341767d = LazyKt.lazy(new c());
        f341768e = t.a();
    }

    public static String b() {
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L7;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L7;
        return r101.W();
    L7:
        return null;
    }

    public static boolean c(DriveFileItem r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = r100.e();
        if (r100.f341573j != DriveFileType.IMAGE) goto L10;
        if (r101 <= ((Number) f341766c.getValue()).longValue()) goto L10;
    L11:
        boolean r102 = true;
    L13:
        boolean r103 = r100.b();
        boolean r104 = UploadFilePolicy.f365565a;
        boolean r105 = !UploadFilePolicy.e(r100.d(false));
        if (r102 == true) goto L19;
        if (r103 == true) goto L20;
        if (r105 == true) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    L10:
        if (UploadFilePolicy.f(r101) == false) goto L11;
        r102 = false;
        goto L13
    }

    public static void d(z79.b r110) {
        Intrinsics.checkNotNullParameter(r110, "galleryContext");
        DriveFileItem r100 = r110.f570685b;
        if (StringsKt.isBlank(r100.f341565b) == false) goto L6;
        FLogger.f375446a.i("DriveGalleryHelper", "[openPreview] Error file token=" + r100.f341565b);
        return;
    L6:
        String r101 = r100.d(true).toLowerCase(Locale.ROOT);
        if (((List) f341767d.getValue()).contains(r101) == false) goto L10;
        s r102 = s.f544207a;
        Context r111 = r110.getContext();
        r102.getClass();
        s.s(r111, R.string.larus_drive_upload_status_formatUnsupported);
        FLogger.f375446a.i("DriveGalleryHelper", "[openPreview] File type not support preview; postfix=" + r101);
        return;
    L10:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 <= 29) goto L13;
    L16:
        f341768e.q(r100.f341565b, r100.f341567d);
        AccountService.f365697a.p("open_document", System.currentTimeMillis(), MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_type", r100.f341573j.getValue()), TuplesKt.to("resource_id", r100.f341565b)}), "DriveGalleryHelper");
        BuildersKt.launch$default(r110.f570686c, null, null, new DriveGalleryHelper$openPreview$1(r110, r100, null), 3, null);
        return;
    L13:
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_DOC, DriveFileType.AI_SLIDES, DriveFileType.AI_SHEET}).contains(r100.f341573j) == false) goto L16;
        s r104 = s.f544207a;
        Context r112 = r110.getContext();
        r104.getClass();
        s.s(r112, R.string.larus_Docs_LowVersion_IncompleteFunction_Tip);
        FLogger.f375446a.i("DriveGalleryHelper", "[openPreview] <= Android 10, not support preview; os=" + r103);
    }

    public static final Object a(DriveGalleryHelper r410, z79.b r411, Continuation r412) {
        final z79.b r100 = r411;
        r410.getClass();
        if ((r412 instanceof DriveGalleryHelper$openMediaPreview$1) == false) goto L7;
        DriveGalleryHelper$openMediaPreview$1 r101 = (DriveGalleryHelper$openMediaPreview$1) r412;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (z79.b) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        if (((Boolean) r103).booleanValue() == true) goto L99;
        r100.f570685b.getClass();
        Pair<Integer, Integer> r106 = t.b().a(r100.getContext());
        final LifecycleCoroutineScope r107 = r100.f570686c;
        Intrinsics.checkNotNullParameter(r107, "scope");
        final String r108 = b();
        String r109 = b();
        IActionBarService r110 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        String r111 = "";
        if (r109 != null) goto L23;
        r109 = "";
    L23:
        List<z0> r112 = r110.f(r109);
        if (r112 == null) goto L41;
        Iterator<T> r113 = r112.iterator();
    L27:
        if (r113.hasNext() == false) goto L39;
        Object r114 = r113.next();
        com.larus.bmhome.actionbar.model.r r115 = ((z0) r114).f295621q;
        if (r115 == null) goto L36;
        Integer r116 = r115.f295408a;
        if (r116 == null) goto L36;
        if (r116.intValue() != 24) goto L36;
        boolean r117 = true;
    L37:
        if (r117 == false) goto L27;
    L40:
        z0 r118 = (z0) r114;
    L42:
        final a r119 = new a(r118);
        String r120 = b();
        IActionBarService r121 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r120 == null) goto L46;
        r111 = r120;
    L46:
        List<z0> r122 = r121.f(r111);
        if (r122 == null) goto L64;
        Iterator<T> r123 = r122.iterator();
    L50:
        if (r123.hasNext() == false) goto L62;
        Object r124 = r123.next();
        com.larus.bmhome.actionbar.model.r r125 = ((z0) r124).f295621q;
        if (r125 == null) goto L59;
        Integer r126 = r125.f295408a;
        if (r126 == null) goto L59;
        if (r126.intValue() != 16) goto L59;
        boolean r127 = true;
    L60:
        if (r127 == false) goto L50;
    L63:
        z0 r128 = (z0) r124;
    L65:
        final a r129 = new a(r128);
        z79.a r130 = new z79.a(new ic8.d(true, new e(r119, r108), null, false, null, null, 60), new ic8.d(true, new f(r129, r108), null, false, null, null, 60), new ic8.d(true, new g(r107), null, false, null, null, 60), new ic8.d(true, new h(r107), null, false, null, null, 60));
        GalleryBuilder r131 = new GalleryBuilder(r100.getContext());
        DriveGalleryDataSource r132 = new DriveGalleryDataSource(r100);
        Intrinsics.checkNotNullParameter(r132, "dataSource");
        r131.f343795b = r132;
        r131.f343796c = 0;
        com.larus.gallery.api.b r133 = new com.larus.gallery.api.b(new com.larus.gallery.api.a(r106.getFirst().intValue(), r106.getSecond().intValue(), DisplayGravity.TOP, new com.larus.gallery.adapter.ui.i(i5.Z())), false, null, 10, false, false, false, null, null, false, 32510);
        Intrinsics.checkNotNullParameter(r133, "displayConfig");
        r131.f343797d = r133;
        r131.a(ProviderType.TOP, new com.larus.drive.sdk.impl.gallery.provider.h(r100));
        r131.a(ProviderType.BOTTOM, new DriveGalleryInputProvider(r100));
        r131.a(ProviderType.RIGHT_SIDE, new com.larus.drive.sdk.impl.gallery.provider.c(r100, r130));
        Function1<? super Dialog, Unit> r134 = new d(r100);
        Intrinsics.checkNotNullParameter(r134, "listener");
        r131.f343800g = r134;
        View r135 = r100.f570690g;
        if (r135 != null) goto L68;
    L86:
        r135 = null;
    L87:
        Intrinsics.checkNotNullParameter("drive_media_preview_dialog", "tag");
        r131.f343806m = "drive_media_preview_dialog";
        r131.f343805l = r135;
        r131.b(null);
        return Unit.INSTANCE;
    L68:
        if (((c2) f341765b.getValue()).f() == true) goto L70;
    L83:
        boolean r136 = false;
    L84:
        if (r136 == false) goto L86;
    L70:
        if ((r135 instanceof GenericDraweeView) == false) goto L83;
        if (r135.getVisibility() != 0) goto L74;
        boolean r137 = true;
    L75:
        if (r137 == false) goto L83;
        GenericDraweeView r138 = (GenericDraweeView) r135;
        if (r138.getWidth() <= 0) goto L83;
        if (r138.getHeight() <= 0) goto L83;
        if (r138.getDrawable() == null) goto L83;
        r136 = true;
        goto L84
    L74:
        r137 = false;
    L59:
        r127 = false;
        goto L60
    L62:
        r124 = null;
        goto L63
    L64:
        r128 = null;
    L36:
        r117 = false;
        goto L37
    L39:
        r114 = null;
        goto L40
    L41:
        r118 = null;
        goto L42
    L99:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = CoroutineScopeKt.coroutineScope(new DriveGalleryHelper$tryOpenUnifiedMediaPreview$2(r100, null), r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new DriveGalleryHelper$openMediaPreview$1(r410, r412);
        goto L8
    }
}
