package com.bytedance.bdp.appbase.address.conetextservice.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/address/conetextservice/entity/ChooseAddressError;", "", "NOT_LOGIN", "EMPTY_ADDRESS_INFO", "bdp-appbase-cpapi_release"}, k = 1, mv = {1, 4, 0})
public final enum ChooseAddressError extends Enum<ChooseAddressError> {
    public static final ChooseAddressError EMPTY_ADDRESS_INFO = null;
    public static final ChooseAddressError NOT_LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChooseAddressError[] f200398a = null;

    static {
        ChooseAddressError r100 = new ChooseAddressError("NOT_LOGIN", 0);
        NOT_LOGIN = r100;
        ChooseAddressError r101 = new ChooseAddressError("EMPTY_ADDRESS_INFO", 1);
        EMPTY_ADDRESS_INFO = r101;
        f200398a = new ChooseAddressError[]{r100, r101};
    }

    public static ChooseAddressError valueOf(String r100) {
        return (ChooseAddressError) a.a(ChooseAddressError.class, r100);
    }

    public static ChooseAddressError[] values() {
        return (ChooseAddressError[]) f200398a.clone();
    }

    public ChooseAddressError(String r100, int r101) {
        super(r100, r101);
    }
}
