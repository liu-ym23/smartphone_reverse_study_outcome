package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

/* JADX INFO: loaded from: classes23.dex */
public class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {
    private ProducerToDataSourceAdapter(Producer<T> r100, SettableProducerContext r101, RequestListener r102) {
        super(r100, r101, r102);
    }

    public static <T> DataSource<T> create(Producer<T> r100, SettableProducerContext r101, RequestListener r102) {
        return new ProducerToDataSourceAdapter(r100, r101, r102);
    }
}
