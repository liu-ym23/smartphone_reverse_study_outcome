package kc5;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.ainote.AINoteListModel;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mc5.j;
import mc5.k;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends AINoteListModel {
    @Override // com.bytedance.ee.bear.list.ainote.AINoteListModel, com.bytedance.ee.bear.list.list.a
    public final String L() {
        return "ai_share_with_me";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteListModel, com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "AIShareListModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/ai_meeting_notes/share_to_me/";
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public final LiveData<ArrayList<Document>> X() {
        MediatorLiveData<List<u1>> r0 = this.m;
        LiveData<List<u1>> r1 = ((j) this.k.a(j.class)).c7(22);
        MediatorLiveData<List<u1>> r2 = this.m;
        Objects.requireNonNull(r2);
        r0.addSource(r1, new ic5.c(r2));
        final MediatorLiveData r3 = new MediatorLiveData();
        final AINoteListModel.TransformFun r4 = new AINoteListModel.TransformFun(this);
        r3.addSource(this.m, new b(r3, r4));
        return r3;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final k p() {
        return new gc5.c(this.k, 22);
    }

    public c(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
