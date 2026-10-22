package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadDataModel;", "", "id", "", "md5", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMd5", "equals", "", "other", "hashCode", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadDataModel {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f457429id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private final String f457430md5;

    public int hashCode() {
        return (this.f457429id.hashCode() * 31) + this.f457430md5.hashCode();
    }

    public final String getId() {
        return this.f457429id;
    }

    public final String getMd5() {
        return this.f457430md5;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PreloadDataModel.class), Reflection.getOrCreateKotlinClass(r100.getClass()))) == true) goto L17;
        PreloadDataModel r101 = (PreloadDataModel) r100;
        if ((!Intrinsics.areEqual(this.f457429id, r101.f457429id)) == false) goto L14;
        return false;
    L14:
        if ((!Intrinsics.areEqual(this.f457430md5, r101.f457430md5)) == false) goto L16;
        return false;
    L16:
        return true;
    }

    public PreloadDataModel(String r100, String r101) {
        this.f457429id = r100;
        this.f457430md5 = r101;
    }
}
