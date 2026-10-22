package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.common.model.field.OptionsRule;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.DynamicFieldViewModel;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicFieldViewModel f211580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OptionsRule f211581b;

    public c(DynamicFieldViewModel r100, OptionsRule r101) {
        this.f211580a = r100;
        this.f211581b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        MutableLiveData<FilterFieldOption> r102 = this.f211580a.getTargetFieldBean();
        Intrinsics.checkNotNull(r101);
        OptionsRule r103 = this.f211581b;
        Iterator<T> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        T r105 = r104.next();
        if (TextUtils.equals(((FilterFieldOption) r105).getId(), r103.getTargetField()) == false) goto L4;
    L9:
        FilterFieldOption r106 = r105;
        if (r106 != null) goto L12;
        r106 = new DynamicFieldViewModel.DeleteField();
        r106.setId(this.f211581b.getTargetField());
        r106.setName(UIHelper.getString(R.string.Bitable_SingleOption_ReferencedFieldDeletedTip_Mobile));
    L12:
        r102.setValue(r106);
        return;
    L8:
        r105 = (T) null;
        goto L9
    }
}
