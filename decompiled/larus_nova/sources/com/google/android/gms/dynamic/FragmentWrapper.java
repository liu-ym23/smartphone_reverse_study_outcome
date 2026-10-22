package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final Fragment f274634zza;

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzA() {
        return this.f274634zza.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzb() {
        return this.f274634zza.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzc() {
        return this.f274634zza.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle zzd() {
        return this.f274634zza.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zze() {
        return wrap(this.f274634zza.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzf() {
        return wrap(this.f274634zza.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.f274634zza.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.f274634zza.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.f274634zza.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String zzj() {
        return this.f274634zza.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.f274634zza.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzt() {
        return this.f274634zza.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzu() {
        return this.f274634zza.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzv() {
        return this.f274634zza.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzw() {
        return this.f274634zza.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzx() {
        return this.f274634zza.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzy() {
        return this.f274634zza.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzz() {
        return this.f274634zza.isResumed();
    }

    private FragmentWrapper(Fragment r100) {
        this.f274634zza = r100;
    }

    public static FragmentWrapper wrap(Fragment r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return new FragmentWrapper(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzk(IObjectWrapper r100) {
        View r101 = (View) ObjectWrapper.unwrap(r100);
        Preconditions.checkNotNull(r101);
        this.f274634zza.registerForContextMenu(r101);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzl(boolean r100) {
        this.f274634zza.setHasOptionsMenu(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzm(boolean r100) {
        this.f274634zza.setMenuVisibility(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzn(boolean r100) {
        this.f274634zza.setRetainInstance(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzo(boolean r100) {
        this.f274634zza.setUserVisibleHint(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzp(Intent r100) {
        this.f274634zza.startActivity(r100);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzr(IObjectWrapper r100) {
        View r101 = (View) ObjectWrapper.unwrap(r100);
        Preconditions.checkNotNull(r101);
        this.f274634zza.unregisterForContextMenu(r101);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzq(Intent r100, int r101) {
        this.f274634zza.startActivityForResult(r100, r101);
    }
}
