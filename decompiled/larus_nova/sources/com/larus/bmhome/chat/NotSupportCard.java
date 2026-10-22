package com.larus.bmhome.chat;

import com.larus.bmhome.chat.cell.buildin.notsupport.NotSupportItemCell;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rR \u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/chat/NotSupportCard;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentCard;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "cellClazz", "Ljava/lang/Class;", "Lcom/larus/ui/arch/component/external/delegate/BaseCellComponentFeature;", "matcher", "Lcom/larus/list/arch/multi/IMultipleType;", "Lcom/larus/list/arch/IFlowListCellState;", "stateTransformer", "Lcom/larus/list/arch/IFlowListCellStateTransformer;", "Lcom/larus/ui/arch/context/external/VCardData;", "<init>", "(Ljava/lang/Class;Lcom/larus/list/arch/multi/IMultipleType;Lcom/larus/list/arch/IFlowListCellStateTransformer;)V", "getCellClazz", "()Ljava/lang/Class;", "getMatcher", "()Lcom/larus/list/arch/multi/IMultipleType;", "getStateTransformer", "()Lcom/larus/list/arch/IFlowListCellStateTransformer;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotSupportCard extends ComponentFeature implements m1a.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<? extends BaseCellComponentFeature<?>> f296975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final hi9.a<? extends ei9.f> f296976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ei9.g<Object, ? extends ei9.f> f296977j;

    public NotSupportCard() {
        this(null);
    }

    @Override // m1a.b
    public final ei9.g<Object, ? extends ei9.f> N() {
        return this.f296977j;
    }

    @Override // m1a.b
    public final hi9.a<? extends ei9.f> getMatcher() {
        return this.f296976i;
    }

    @Override // m1a.b
    public final Class<? extends BaseCellComponentFeature<?>> l1() {
        return this.f296975h;
    }

    public NotSupportCard(Object r100) {
        xc8.j r101 = new xc8.j();
        xc8.i r102 = xc8.k.a(new zc8.b());
        Intrinsics.checkNotNullParameter(NotSupportItemCell.class, "cellClazz");
        Intrinsics.checkNotNullParameter(r101, "matcher");
        Intrinsics.checkNotNullParameter(r102, "stateTransformer");
        this.f296975h = NotSupportItemCell.class;
        this.f296976i = r101;
        this.f296977j = r102;
    }
}
