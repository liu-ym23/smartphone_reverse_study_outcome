package com.obric.assistant.interaction.impl.permission;

import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.platform.api.g1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "", "RequestBasic", "RequestDetail", "RequestWithMap", "RequestFull", "RequestNotification", "ShowSettingDialog", "RequestAny", "GoSettings", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$GoSettings;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestAny;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestBasic;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestDetail;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestFull;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestNotification;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestWithMap;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask$ShowSettingDialog;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PermissionTask {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$GoSettings;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "<init>", "(Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;)V", "getCallback", "()Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GoSettings implements PermissionTask {
        private final g1.c callback;

        public static /* synthetic */ GoSettings copy$default(GoSettings r100, g1.c r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.callback;
        L6:
            return r100.copy(r101);
        }

        public final g1.c component1() {
            return this.callback;
        }

        public final GoSettings copy(g1.c r100) {
            return new GoSettings(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GoSettings) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.callback, ((GoSettings) r100).callback) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            g1.c r100 = this.callback;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "GoSettings(callback=" + this.callback + ')';
        }

        public final g1.c getCallback() {
            return this.callback;
        }

        public GoSettings(g1.c r100) {
            this.callback = r100;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestAny;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", ErrorType.MANIFEST, "", "", "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "<init>", "(Ljava/util/List;Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;)V", "getManifest", "()Ljava/util/List;", "getCallback", "()Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestAny implements PermissionTask {
        private final g1.c callback;
        private final List<String> manifest;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestAny copy$default(RequestAny r100, List r101, g1.c r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.callback;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<String> component1() {
            return this.manifest;
        }

        public final g1.c component2() {
            return this.callback;
        }

        public final RequestAny copy(List<String> r100, g1.c r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            return new RequestAny(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestAny) == true) goto L8;
            return false;
        L8:
            RequestAny r101 = (RequestAny) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.manifest.hashCode() * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "RequestAny(manifest=" + this.manifest + ", callback=" + this.callback + ')';
        }

        public final g1.c getCallback() {
            return this.callback;
        }

        public final List<String> getManifest() {
            return this.manifest;
        }

        public RequestAny(List<String> r100, g1.c r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.manifest = r100;
            this.callback = r101;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestBasic;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", ErrorType.MANIFEST, "", "", "callback", "Lkotlin/Function1;", "", "", "Lcom/larus/permission/api/RequestPermissionCallback;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getManifest", "()Ljava/util/List;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestBasic implements PermissionTask {
        private final Function1<Boolean, Unit> callback;
        private final List<String> manifest;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestBasic copy$default(RequestBasic r100, List r101, Function1 r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.callback;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<String> component1() {
            return this.manifest;
        }

        public final Function1<Boolean, Unit> component2() {
            return this.callback;
        }

        public final RequestBasic copy(List<String> r100, Function1<? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            return new RequestBasic(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestBasic) == true) goto L8;
            return false;
        L8:
            RequestBasic r101 = (RequestBasic) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.manifest.hashCode() * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "RequestBasic(manifest=" + this.manifest + ", callback=" + this.callback + ')';
        }

        public final Function1<Boolean, Unit> getCallback() {
            return this.callback;
        }

        public final List<String> getManifest() {
            return this.manifest;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RequestBasic(List<String> r100, Function1<? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.manifest = r100;
            this.callback = r101;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Br\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012[\u0010\u0005\u001aW\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J^\u0010\u0016\u001aW\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u000eHÆ\u0003Jx\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032]\b\u0002\u0010\u0005\u001aW\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u000eHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012Rf\u0010\u0005\u001aW\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestDetail;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", ErrorType.MANIFEST, "", "", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "allGranted", "grantedList", "deniedList", "", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "getManifest", "()Ljava/util/List;", "getCallback", "()Lkotlin/jvm/functions/Function3;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestDetail implements PermissionTask {
        private final Function3<Boolean, List<String>, List<String>, Unit> callback;
        private final List<String> manifest;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestDetail copy$default(RequestDetail r100, List r101, Function3 r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.callback;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<String> component1() {
            return this.manifest;
        }

        public final Function3<Boolean, List<String>, List<String>, Unit> component2() {
            return this.callback;
        }

        public final RequestDetail copy(List<String> r100, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            return new RequestDetail(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestDetail) == true) goto L8;
            return false;
        L8:
            RequestDetail r101 = (RequestDetail) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.manifest.hashCode() * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "RequestDetail(manifest=" + this.manifest + ", callback=" + this.callback + ')';
        }

        public final Function3<Boolean, List<String>, List<String>, Unit> getCallback() {
            return this.callback;
        }

        public final List<String> getManifest() {
            return this.manifest;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RequestDetail(List<String> r100, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.manifest = r100;
            this.callback = r101;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestFull;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", ErrorType.MANIFEST, "", "", "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "subTitleMap", "", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "", "<init>", "(Ljava/util/List;Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;Ljava/util/Map;Lorg/json/JSONObject;Z)V", "getManifest", "()Ljava/util/List;", "getCallback", "()Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "getSubTitleMap", "()Ljava/util/Map;", "getTrackInfo", "()Lorg/json/JSONObject;", "getShowGoSettingsDialog", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestFull implements PermissionTask {
        private final g1.c callback;
        private final List<String> manifest;
        private final boolean showGoSettingsDialog;
        private final Map<String, String> subTitleMap;
        private final JSONObject trackInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestFull copy$default(RequestFull r100, List r101, g1.c r102, Map r103, JSONObject r104, boolean r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.callback;
        L8:
            g1.c r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.subTitleMap;
        L11:
            Map r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.trackInfo;
        L14:
            JSONObject r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.showGoSettingsDialog;
        L17:
            List r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final List<String> component1() {
            return this.manifest;
        }

        public final g1.c component2() {
            return this.callback;
        }

        public final Map<String, String> component3() {
            return this.subTitleMap;
        }

        public final JSONObject component4() {
            return this.trackInfo;
        }

        public final boolean component5() {
            return this.showGoSettingsDialog;
        }

        public final RequestFull copy(List<String> r100, g1.c r101, Map<String, String> r110, JSONObject r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            return new RequestFull(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestFull) == true) goto L8;
            return false;
        L8:
            RequestFull r101 = (RequestFull) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.subTitleMap, r101.subTitleMap) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.trackInfo, r101.trackInfo) == true) goto L21;
            return false;
        L21:
            if (this.showGoSettingsDialog == r101.showGoSettingsDialog) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.manifest.hashCode() * 31) + this.callback.hashCode()) * 31;
            Map<String, String> r101 = this.subTitleMap;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            JSONObject r105 = this.trackInfo;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (r104 + r102) * 31;
            if (this.showGoSettingsDialog == false) goto L13;
            int r107 = 1231;
        L15:
            return r106 + r107;
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "RequestFull(manifest=" + this.manifest + ", callback=" + this.callback + ", subTitleMap=" + this.subTitleMap + ", trackInfo=" + this.trackInfo + ", showGoSettingsDialog=" + this.showGoSettingsDialog + ')';
        }

        public final g1.c getCallback() {
            return this.callback;
        }

        public final List<String> getManifest() {
            return this.manifest;
        }

        public final boolean getShowGoSettingsDialog() {
            return this.showGoSettingsDialog;
        }

        public final Map<String, String> getSubTitleMap() {
            return this.subTitleMap;
        }

        public final JSONObject getTrackInfo() {
            return this.trackInfo;
        }

        public RequestFull(List<String> r100, g1.c r101, Map<String, String> r102, JSONObject r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.manifest = r100;
            this.callback = r101;
            this.subTitleMap = r102;
            this.trackInfo = r103;
            this.showGoSettingsDialog = r104;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestNotification;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "isLaunching", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestNotification implements PermissionTask {
        private final boolean isLaunching;

        public static /* synthetic */ RequestNotification copy$default(RequestNotification r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.isLaunching;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.isLaunching;
        }

        public final RequestNotification copy(boolean r100) {
            return new RequestNotification(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestNotification) == true) goto L9;
            return false;
        L9:
            if (this.isLaunching == ((RequestNotification) r100).isLaunching) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.isLaunching == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "RequestNotification(isLaunching=" + this.isLaunching + ')';
        }

        public final boolean isLaunching() {
            return this.isLaunching;
        }

        public RequestNotification(boolean r100) {
            this.isLaunching = r100;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tHÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$RequestWithMap;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", ErrorType.MANIFEST, "", "", "callback", "Lkotlin/Function1;", "", "", "Lcom/larus/permission/api/RequestPermissionCallback;", "subTitleMap", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/util/Map;)V", "getManifest", "()Ljava/util/List;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getSubTitleMap", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestWithMap implements PermissionTask {
        private final Function1<Boolean, Unit> callback;
        private final List<String> manifest;
        private final Map<String, String> subTitleMap;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestWithMap copy$default(RequestWithMap r100, List r101, Function1 r102, Map r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.manifest;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.callback;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.subTitleMap;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final List<String> component1() {
            return this.manifest;
        }

        public final Function1<Boolean, Unit> component2() {
            return this.callback;
        }

        public final Map<String, String> component3() {
            return this.subTitleMap;
        }

        public final RequestWithMap copy(List<String> r100, Function1<? super Boolean, Unit> r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            return new RequestWithMap(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RequestWithMap) == true) goto L8;
            return false;
        L8:
            RequestWithMap r101 = (RequestWithMap) r100;
            if (Intrinsics.areEqual(this.manifest, r101.manifest) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.subTitleMap, r101.subTitleMap) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.manifest.hashCode() * 31) + this.callback.hashCode()) * 31;
            Map<String, String> r101 = this.subTitleMap;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "RequestWithMap(manifest=" + this.manifest + ", callback=" + this.callback + ", subTitleMap=" + this.subTitleMap + ')';
        }

        public final Function1<Boolean, Unit> getCallback() {
            return this.callback;
        }

        public final List<String> getManifest() {
            return this.manifest;
        }

        public final Map<String, String> getSubTitleMap() {
            return this.subTitleMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RequestWithMap(List<String> r100, Function1<? super Boolean, Unit> r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.manifest = r100;
            this.callback = r101;
            this.subTitleMap = r102;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionTask$ShowSettingDialog;", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "permission", "", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;)V", "getPermission", "()Ljava/lang/String;", "getSubTitle", "getCallback", "()Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShowSettingDialog implements PermissionTask {
        private final g1.b callback;
        private final String permission;
        private final String subTitle;

        public static /* synthetic */ ShowSettingDialog copy$default(ShowSettingDialog r100, String r101, String r102, g1.b r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.permission;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.subTitle;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.callback;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.permission;
        }

        public final String component2() {
            return this.subTitle;
        }

        public final g1.b component3() {
            return this.callback;
        }

        public final ShowSettingDialog copy(String r100, String r101, g1.b r102) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            return new ShowSettingDialog(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ShowSettingDialog) == true) goto L8;
            return false;
        L8:
            ShowSettingDialog r101 = (ShowSettingDialog) r100;
            if (Intrinsics.areEqual(this.permission, r101.permission) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.permission.hashCode() * 31;
            String r101 = this.subTitle;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            g1.b r105 = this.callback;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "ShowSettingDialog(permission=" + this.permission + ", subTitle=" + this.subTitle + ", callback=" + this.callback + ')';
        }

        public final g1.b getCallback() {
            return this.callback;
        }

        public final String getPermission() {
            return this.permission;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public ShowSettingDialog(String r100, String r101, g1.b r102) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            this.permission = r100;
            this.subTitle = r101;
            this.callback = r102;
        }
    }
}
