package com.bytedance.caijing.sdk.infra.base.api.container.annieXCard;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import ed4.a;
import ed4.b;
import ed4.c;
import ed4.d;
import ed4.h;
import ed4.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH&J\u001a\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/annieXCard/ICJAnnieCardService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Led4/a;", "cardContext", "Led4/b;", "cardModel", "Led4/h;", "getCJAnnieCardFactory", "Led4/c;", "Led4/d;", "Led4/k;", "getCJAnnieWebCardFactory", "getCJBulletCardFactory", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJAnnieCardService extends ICJService {
    h getCJAnnieCardFactory(a r100, b r101);

    k getCJAnnieWebCardFactory(c r100, d r101);

    k getCJBulletCardFactory(c r100, d r101);
}
