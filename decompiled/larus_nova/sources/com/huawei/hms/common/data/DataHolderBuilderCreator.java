package com.huawei.hms.common.data;

import android.content.ContentValues;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
final class DataHolderBuilderCreator extends DataHolder.Builder {
    @Override // com.huawei.hms.common.data.DataHolder.Builder
    public final DataHolder.Builder setDataForContentValuesHashMap(HashMap<String, Object> r100) {
        throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported setDataForContentValuesHashMap");
    }

    @Override // com.huawei.hms.common.data.DataHolder.Builder
    public final DataHolder.Builder withRow(ContentValues r100) {
        throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported withRow");
    }

    public DataHolderBuilderCreator(String[] r100, String r101) {
        super(r100, null, null);
    }
}
