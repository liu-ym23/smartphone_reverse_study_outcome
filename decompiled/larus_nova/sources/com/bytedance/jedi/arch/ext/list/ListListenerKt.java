package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0084\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0019\b\n\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\u001f\b\n\u0010\b\u001a\u0019\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u00072%\b\n\u0010\u000b\u001a\u001f\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u0007H\u0087\b\u001a\u0084\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0019\b\n\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\u001f\b\n\u0010\b\u001a\u0019\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u00072%\b\n\u0010\u000b\u001a\u001f\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\u0007H\u0086\b*J\b\u0007\u0010\u0000\u001a\u0004\b\u0000\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001B\u0018\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\b\u0011\u0012\u0006\b\n0\u00128\u0013¨\u0006\u0014"}, d2 = {"JediListListener", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", ExifInterface.GPS_DIRECTION_TRUE, "RECEIVER", "onLoading", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function2;", "", "onSuccess", "", "ListListener", "Lkotlin/Deprecated;", "message", "use ListListener", "level", "Lkotlin/DeprecationLevel;", "WARNING", "ext_list_release"}, k = 2, mv = {1, 1, 16})
public final class ListListenerKt {

    /* JADX INFO: Add missing generic type declarations: [T, RECEIVER] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ext.list.ListListenerKt$JediListListener$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001R+\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR1\u0010\r\u001a\u001f\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"com/bytedance/jedi/arch/ext/list/ListListenerKt$JediListListener$4", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function2;", "", "", "Lkotlin/ExtensionFunctionType;", "getOnError", "()Lkotlin/jvm/functions/Function2;", "onLoading", "Lkotlin/Function1;", "getOnLoading", "()Lkotlin/jvm/functions/Function1;", "onSuccess", "", "getOnSuccess", "ext_list_release"}, k = 1, mv = {1, 1, 16})
    public static final class AnonymousClass4<RECEIVER, T> implements ListListener<T, RECEIVER> {
        final /* synthetic */ Function2 $onError;
        final /* synthetic */ Function1 $onLoading;
        final /* synthetic */ Function2 $onSuccess;
        private final Function2<RECEIVER, Throwable, Unit> onError;
        private final Function1<RECEIVER, Unit> onLoading;
        private final Function2<RECEIVER, List<? extends T>, Unit> onSuccess;

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function2<RECEIVER, Throwable, Unit> getOnError() {
            return this.onError;
        }

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function1<RECEIVER, Unit> getOnLoading() {
            return this.onLoading;
        }

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function2<RECEIVER, List<? extends T>, Unit> getOnSuccess() {
            return this.onSuccess;
        }

        public AnonymousClass4(Function1 r100, Function2 r101, Function2 r102) {
            this.$onLoading = r100;
            this.$onError = r101;
            this.$onSuccess = r102;
            this.onLoading = r100;
            this.onError = r101;
            this.onSuccess = r102;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, RECEIVER] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ext.list.ListListenerKt$ListListener$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001R+\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR1\u0010\r\u001a\u001f\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"com/bytedance/jedi/arch/ext/list/ListListenerKt$ListListener$4", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function2;", "", "", "Lkotlin/ExtensionFunctionType;", "getOnError", "()Lkotlin/jvm/functions/Function2;", "onLoading", "Lkotlin/Function1;", "getOnLoading", "()Lkotlin/jvm/functions/Function1;", "onSuccess", "", "getOnSuccess", "ext_list_release"}, k = 1, mv = {1, 1, 16})
    public static final class C105964<RECEIVER, T> implements ListListener<T, RECEIVER> {
        final /* synthetic */ Function2 $onError;
        final /* synthetic */ Function1 $onLoading;
        final /* synthetic */ Function2 $onSuccess;
        private final Function2<RECEIVER, Throwable, Unit> onError;
        private final Function1<RECEIVER, Unit> onLoading;
        private final Function2<RECEIVER, List<? extends T>, Unit> onSuccess;

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function2<RECEIVER, Throwable, Unit> getOnError() {
            return this.onError;
        }

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function1<RECEIVER, Unit> getOnLoading() {
            return this.onLoading;
        }

        @Override // com.bytedance.jedi.arch.ext.list.ListListener
        public Function2<RECEIVER, List<? extends T>, Unit> getOnSuccess() {
            return this.onSuccess;
        }

        public C105964(Function1 r100, Function2 r101, Function2 r102) {
            this.$onLoading = r100;
            this.$onError = r101;
            this.$onSuccess = r102;
            this.onLoading = r100;
            this.onError = r101;
            this.onSuccess = r102;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "use ListListener")
    public static /* synthetic */ void JediListListener$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "use ListListener")
    public static final <T, RECEIVER> ListListener<T, RECEIVER> JediListListener(Function1<? super RECEIVER, Unit> r100, Function2<? super RECEIVER, ? super Throwable, Unit> r101, Function2<? super RECEIVER, ? super List<? extends T>, Unit> r102) {
        return new AnonymousClass4(r100, r101, r102);
    }

    public static final <T, RECEIVER> ListListener<T, RECEIVER> ListListener(Function1<? super RECEIVER, Unit> r100, Function2<? super RECEIVER, ? super Throwable, Unit> r101, Function2<? super RECEIVER, ? super List<? extends T>, Unit> r102) {
        return new C105964(r100, r101, r102);
    }

    public static /* synthetic */ ListListener JediListListener$default(Function1 r100, Function2 r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = AnonymousClass1.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = AnonymousClass2.INSTANCE;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = AnonymousClass3.INSTANCE;
    L12:
        return new AnonymousClass4(r100, r101, r102);
    }

    public static /* synthetic */ ListListener ListListener$default(Function1 r100, Function2 r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = C105931.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = C105942.INSTANCE;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = C105953.INSTANCE;
    L12:
        return new C105964(r100, r101, r102);
    }
}
