package com.larus.login.impl;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class i<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccountCountryPickerFragment f357768a;

    public i(AccountCountryPickerFragment r100) {
        this.f357768a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        AccountCountryPickerFragment r102 = this.f357768a;
        int r103 = AccountCountryPickerFragment.f357119g;
        r102.getClass();
        String r104 = AccountCountryPickerFragment.U90((JSONObject) r100);
        this.f357768a.getClass();
        return ComparisonsKt.compareValues(r104, AccountCountryPickerFragment.U90((JSONObject) r101));
    }
}
