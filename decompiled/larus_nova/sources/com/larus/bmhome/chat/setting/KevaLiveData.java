package com.larus.bmhome.chat.setting;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wi8.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0018BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\t¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/setting/KevaLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "repo", "Lcom/bytedance/keva/Keva;", "key", "", "getter", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setter", "Lkotlin/Function2;", "", "<init>", "(Lcom/bytedance/keva/Keva;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "changeListener", "Lcom/bytedance/keva/Keva$OnChangeListener;", "onActive", "onInactive", "setValue", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KevaLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f308891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f308892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Keva, T> f308893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Keva, T, Unit> f308894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f308895e;

    public static final class a {
    }

    static {
    }

    @Override // androidx.lifecycle.LiveData
    public final T getValue() {
        return this.f308893c.invoke(this.f308891a);
    }

    @Override // androidx.lifecycle.LiveData
    public final void onActive() {
        super.onActive();
        this.f308891a.registerChangeListener(this.f308895e);
    }

    @Override // androidx.lifecycle.LiveData
    public final void onInactive() {
        super.onInactive();
        this.f308891a.unRegisterChangeListener(this.f308895e);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        FLogger.f375446a.d("KevaLiveData", "set: " + this.f308892b + com.alipay.sdk.m.n.a.f25612h + r100);
        this.f308894d.invoke(this.f308891a, r100);
        super.setValue(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [wi8.f] */
    public KevaLiveData(Keva r100, String r101, Function1<? super Keva, ? extends T> r102, Function2<? super Keva, ? super T, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "getter");
        Intrinsics.checkNotNullParameter(r103, "setter");
        super(r102.invoke(r100));
        this.f308891a = r100;
        this.f308892b = r101;
        this.f308893c = r102;
        this.f308894d = r103;
        this.f308895e = new f(this);
    }
}
