package com.ss.android.lark.picker.base.widget.business;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u0012\u0010\u0016\u001a\u00020\u00002\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u0012\u0010\u0019\u001a\u00020\u00002\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u000bJ(\u0010\u001a\u001a\u00020\u00002 \u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000b\u0018\u00010\tj\u0004\u0018\u0001`\fJ\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u001dJ\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u001dR$\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000b0\tj\u0002`\fX\u0082\u000e¢\u0006\u0002\n\u0000R?\u0010\r\u001a3\u0012/\u0012-\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000b0\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0013\u001a3\u0012/\u0012-\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000b0\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/business/ContactsSelectorBusiness;", "Lcom/ss/android/lark/picker/base/widget/business/ICustomBusiness;", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "<init>", "()V", "applyTo", "", "controller", "dataConverter", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/picker/base/widget/business/Converter;", "addHeaderActions", "", "Lkotlin/ParameterName;", "name", "list", "Lcom/ss/android/lark/picker/base/widget/business/Expressions;", "addFooterActions", "addHeaderView", BaseSwitches.V, "addHeaderList", "adapter", "addFooterView", "addFooterList", "setConverter", "converter", "convertHead", "", "convertBack", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactsSelectorBusiness implements ICustomBusiness<PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController> {
    private final List<Function1<List<RecyclerView.Adapter<?>>, Unit>> addFooterActions;
    private final List<Function1<List<RecyclerView.Adapter<?>>, Unit>> addHeaderActions;
    private Function1<? super View, ? extends RecyclerView.Adapter<?>> dataConverter;

    public final List<RecyclerView.Adapter<?>> convertBack() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.addFooterActions.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    L7:
        return CollectionsKt.filterNotNull(r100);
    }

    public final List<RecyclerView.Adapter<?>> convertHead() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.addHeaderActions.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    L7:
        return CollectionsKt.filterNotNull(r100);
    }

    public ContactsSelectorBusiness() {
        this.dataConverter = ContactsSelectorBusiness$dataConverter$1.INSTANCE;
        this.addHeaderActions = new ArrayList();
        this.addFooterActions = new ArrayList();
    }

    public static final /* synthetic */ Function1 access$getDataConverter$p(ContactsSelectorBusiness r100) {
        return r100.dataConverter;
    }

    public final ContactsSelectorBusiness addFooterList(final RecyclerView.Adapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.addFooterActions.add(new ContactsSelectorBusiness$addFooterList$1$1(r100));
        return this;
    }

    public final ContactsSelectorBusiness addFooterView(final View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.addFooterActions.add(new ContactsSelectorBusiness$addFooterView$1$1(this, r100));
        return this;
    }

    public final ContactsSelectorBusiness addHeaderList(final RecyclerView.Adapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.addHeaderActions.add(new ContactsSelectorBusiness$addHeaderList$1$1(r100));
        return this;
    }

    public final ContactsSelectorBusiness addHeaderView(final View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.addHeaderActions.add(new ContactsSelectorBusiness$addHeaderView$1$1(this, r100));
        return this;
    }

    /* JADX INFO: renamed from: applyTo, reason: avoid collision after fix types in other method */
    public void applyTo2(PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        r100.setContactsSelectorBusiness(this);
    }

    public final ContactsSelectorBusiness setConverter(Function1<? super View, ? extends RecyclerView.Adapter<?>> r100) {
        if (r100 == null) goto L5;
        this.dataConverter = r100;
    L5:
        return this;
    }

    @Override // com.ss.android.lark.picker.base.widget.business.ICustomBusiness
    public /* bridge */ /* synthetic */ void applyTo(PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController r100) {
        applyTo2(r100);
    }
}
